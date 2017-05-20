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

public class Parser {
	private SalesDAO salesDao;
	
	private AdjustmentDAO adjustementsDao;
	
	public Parser(SalesDAO salesDao ,AdjustmentDAO adjustementsDAO) {
		this.salesDao = salesDao;
		this.adjustementsDao = adjustementsDAO;
	}
	
	public Action parse (Message message) {
		List<Sale> sales= salesDao.getSales();
		if (!(message.getCommand().equals(Command.SALE))) {
			List<Adjustment> adjustements= adjustementsDao.getAdjustements();
			return new Action() {
				public void execute () {
					BigDecimal totalBefore = BigDecimal.ZERO,totalAfter = BigDecimal.ZERO,totalQty = BigDecimal.ZERO;
					for (Sale sale:sales) {
						BigDecimal messagePrice = message.getPrice();
						if (sale.getProductType().equals(message.getProductType())) {
							BigDecimal salePrice=sale.getPrice();
							BigDecimal saleQty=sale.getQty();
							totalBefore = totalBefore.add(salePrice.multiply(saleQty));
							switch (message.getCommand()) {
							case ADD: sale.setPrice(salePrice.add(messagePrice));break;
							case SUBTRACT: sale.setPrice(salePrice.subtract(messagePrice));break;
							case MULTIPLY: sale.setPrice(salePrice.multiply(messagePrice));break;
							}
							totalAfter = totalAfter.add(sale.getPrice().multiply(saleQty));
							totalQty = totalQty.add(saleQty);
						}
					}
					adjustements.add(new Adjustment(totalBefore,totalAfter,totalQty,message.getCommand(),message.getPrice(),message.getProductType()));
				}
			};
		} else {
			return new Action() {
				public void execute () {
					sales.add(new Sale(message.getProductType(),message.getPrice(),message.getQty()));
				}
			};
		}
	}
}