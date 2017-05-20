/**
 * 
 */
package com.jpm.msg.prc.view;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.jpm.msg.prc.model.Adjustment;
import com.jpm.msg.prc.model.Sale;

// TODO: Auto-generated Javadoc
/**
 * The Class ConsoleDisplay.
 *
 * @author sud
 * This class helps display the logs in the console.
 */
public class ConsoleDisplay {
	
	/**
	 * Report after each 10 sales.
	 *
	 * @param sales the sales
	 */
	public static void reportAfterEach10Sales (List<Sale> sales) {
		HashMap<String,Sale> res = new HashMap<String,Sale>();
		BigDecimal totalValue = BigDecimal.ZERO;
		for (Sale sale : sales) {
			String productType = sale.getProductType();
			Sale totalSale = res.get(productType);
			BigDecimal value = sale.getQty().multiply(sale.getPrice());
			totalValue = totalValue.add(value);
			if (totalSale!=null) {
				totalSale.setQty(totalSale.getQty().add(sale.getQty()));
				totalSale.setPrice(totalSale.getPrice().add(value));//price as value in this use case
			} else {
				totalSale= new Sale(productType, value, sale.getQty());
			}
			res.put(productType, totalSale);
		}
		
		System.out.println("After each 10 sales report");
		System.out.println(" ------------------------------------------- ");
		System.out.println("|            product|       value|       qty|");
		System.out.println("|-------------------|------------|----------|");
		for (Sale sale: res.values()) {
			System.out.println(sale);
		}
		System.out.println("|-------------------|------------|----------|");
		System.out.println("|        total sales|"+String.format("%1$12s", totalValue.toString())+"|          |");
		System.out.println(" ------------------------------------------- ");
		System.out.println();
		}
	
	/**
	 * Report after 50 sales.
	 *
	 * @param adjustements the adjustments
	 */
	public static void reportAfter50Sales (List<Adjustment> adjustements) {
		System.out.println("50 processed messsages limit reached. Adjustements made so far:");
		for (Adjustment adjustement: adjustements) {
			System.out.println(adjustement);
		}
		System.exit(1);
	}
}
