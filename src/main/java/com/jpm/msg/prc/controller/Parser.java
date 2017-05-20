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

import com.jpm.msg.prc.dao.AdjustmentDAO;
import com.jpm.msg.prc.dao.SalesDAO;
import com.jpm.msg.prc.model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Parser.
 */
public class Parser {
	
	/** The sales dao. */
	private SalesDAO salesDao;
	
	/** The adjustements dao. */
	private AdjustmentDAO adjustementsDao;
	
	/**
	 * Instantiates a new parser.
	 *
	 * @param salesDao the sales dao
	 * @param adjustementsDAO the adjustements DAO
	 */
	public Parser(SalesDAO salesDao ,AdjustmentDAO adjustementsDAO) {
		this.salesDao = salesDao;
		this.adjustementsDao = adjustementsDAO;
	}
	
	/**
	 * Parses the.
	 *
	 * @param message the message
	 */
	public void parse (Message message) {
		List<Sale> sales= salesDao.getSales();
		if (!(message.getCommand().equals(Operation.SALE))) {
			List<Adjustment> adjustements= adjustementsDao.getAdjustements();
			modifyAdjustments(sales,adjustements,message);
				
		} else {
			addSales(sales, message);
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
		BigDecimal totalBefore = BigDecimal.ZERO,totalAfter = BigDecimal.ZERO,totalQty = BigDecimal.ZERO;
		for (Sale sale:sales) {
			BigDecimal messagePrice = message.getPrice();
			if (sale.getProductType().equals(message.getProductType())) {
				BigDecimal salePrice=sale.getPrice();
				BigDecimal saleQty=sale.getQty();
				totalBefore = totalBefore.add(salePrice.multiply(saleQty));
				switch (message.getCommand()) {
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
		adjustments.add(new Adjustment(totalBefore,totalAfter,totalQty,message.getCommand(),message.getPrice(),message.getProductType()));
	}
	
	/**
	 * Adds the sales.
	 *
	 * @param sales the sales
	 * @param message the message
	 */
	public void addSales(List<Sale> sales, Message message){
		sales.add(new Sale(message.getProductType(),message.getPrice(),message.getQty()));
	}
}
	