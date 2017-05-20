/**
 * 
 */
package com.jpm.msg.prc.controller;

/**
 * @author sud
 *
 */
import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.jpm.msg.prc.dao.AdjustmentDAO;
import com.jpm.msg.prc.dao.SalesDAO;
import com.jpm.msg.prc.model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Parser.
 */
public class DataController {
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(DataController.class);

	/** The sales DAO. */
	private SalesDAO salesDao;
	
	/** The adjustments DAO. */
	private AdjustmentDAO adjustmentsDao;
	
	/**
	 * Instantiates a new parser.
	 *
	 * @param salesDao the sales DAO
	 * @param adjustementsDAO the adjustments DAO
	 */
	public DataController(SalesDAO salesDao ,AdjustmentDAO adjustementsDAO) {
		this.salesDao = salesDao;
		this.adjustmentsDao = adjustementsDAO;
	}
	
	/**
	 * Parses the.
	 *
	 * @param message 
	 */
	public void parse (Message message) {
		try{
			List<Sale> sales= salesDao.getAllSales();
			if (!(message.getOperation().equals(Operation.SALE))) {
				log.info("Addding a operation sale data" );
				List<Adjustment> adjustements= adjustmentsDao.getAllAdjustments();
				modifyAdjustments(sales,adjustements,message);
					
			} else {
				log.info("Addding a normal sale data" );
				addSales(sales, message);
			}
		}catch( Exception ex ) {
			System.out.println(ex.toString());
		    log.log( Level.FATAL, ex.toString(), ex);
		}
	}
	
	/**
	 * Modify adjustments.
	 *
	 * @param sales the sales
	 * @param adjustments the adjustments
	 * @param message the message
	 */
	public void modifyAdjustments (List<Sale> sales, List<Adjustment> adjustments, Message message) {
		try{
			BigDecimal 	totalBefore = BigDecimal.ZERO,
						totalAfter = BigDecimal.ZERO,
						totalQty = BigDecimal.ZERO;
			for (Sale sale:sales) {
				BigDecimal messagePrice = message.getPrice();
				if (sale.getProductType().equals(message.getProductType())) {
					BigDecimal salePrice=sale.getPrice();
					BigDecimal saleQty=sale.getQty();
					/**
					 * Check for the operation type and perform the operation on the sale
					 */
					totalBefore = totalBefore.add(salePrice.multiply(saleQty));
					switch (message.getOperation()) {
						case ADD: 
							sale.setPrice(salePrice.add(messagePrice));
							break;
						case SUBTRACT: 
							sale.setPrice(salePrice.subtract(messagePrice));
							break;
						case MULTIPLY: 
							sale.setPrice(salePrice.multiply(messagePrice));
							break;
						default:
							break;
					}
					totalAfter = totalAfter.add(sale.getPrice().multiply(saleQty));
					totalQty = totalQty.add(saleQty);
				}
			}
			adjustments.add(new Adjustment(
											totalBefore,
											totalAfter,
											totalQty,
											message.getOperation(),
											message.getPrice(),
											message.getProductType())
										  );
		}catch( Exception ex ) {
			System.out.println(ex.toString());
		    log.log( Level.FATAL, ex.toString(), ex);
		}
	}
	
	/**
	 * Adds the normal sales.
	 *
	 * @param sales
	 * @param message 
	 */
	public void addSales(List<Sale> sales, Message message){
		try{
			sales.add(new Sale(
								message.getProductType(),
								message.getPrice(),
								message.getQty())
							  );
		}catch( Exception ex ) {
			System.out.println(ex.toString());
		    log.log( Level.FATAL, ex.toString(), ex);
		}
	}
}
	