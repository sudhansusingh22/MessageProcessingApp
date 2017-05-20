/**
 * 
 */
package com.jpm.msg.prc.view;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.jpm.msg.prc.controller.DataController;
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
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(DataController.class);

	/**
	 * Report after each 10 sales.
	 *
	 * @param sales the sales
	 */
	public static void reportAfter10 (List<Sale> sales, int count) {
		try{
			Map<String,Sale> res = new HashMap<>();
			BigDecimal totalValue = BigDecimal.ZERO;
			BigDecimal totalQty = BigDecimal.ZERO;
			for (Sale sale : sales) {
				Sale totalSale = res.get(sale.getProductType());
				BigDecimal value = sale.getQty().multiply(sale.getPrice());
				totalValue = totalValue.add(value);
				totalQty = totalQty.add(sale.getQty());
				if (totalSale!=null) {
					totalSale.setQty(totalSale.getQty().add(sale.getQty()));
					totalSale.setPrice(totalSale.getPrice().add(value));
				} else {
					totalSale= new Sale(sale.getProductType(), value, sale.getQty());
				}
				res.put(sale.getProductType(), totalSale);
			}
			
			System.out.println(">>> Report after "+ count + " sales: "+ "\n");
			System.out.println(" ******************************************* ");
			System.out.println("|       Product Name|       Price|  Quantity|");
			System.out.println("|*******************|************|**********|");
			for (Sale sale: res.values()) {
				System.out.println(sale);
			}
			System.out.println("|-------------------|------------|----------|");
			System.out.println("|              Total|"+String.format("%1$12s", totalValue.toString())+"|" +String.format("%1$10s", totalQty.toString())+"|");
			System.out.println(" ------------------------------------------- ");
			System.out.println();
		}catch( Exception ex ) {
			System.out.println(ex.toString());
		    log.log( Level.FATAL, ex.toString(), ex);
		}
	}
	
	/**
	 * Report after 50 sales.
	 *
	 * @param adjustements the adjustments
	 */
	public static void finalReport (List<Adjustment> adjustements) {
		try{
			System.out.println(">>> 50 Messages processed! Adjustment Report:\n");
			System.out.println(" ********************************************************************************************* ");
			System.out.println("|    Product Name|       Operation|       Price|  Quantity|   Previous Amount|      New Amount|");
			System.out.println("|****************|****************|************|**********|******************|****************|");
			for (Adjustment adjustement: adjustements) {
				System.out.println(adjustement);
			}
			System.out.println(" --------------------------------------------------------------------------------------------- ");
			System.out.println("\n>>> Exiting the System! \n>>> Goodbye!!");
			System.exit(1);
		}catch( Exception ex ) {
			System.out.println(ex.toString());
		    log.log( Level.FATAL, ex.toString(), ex);
		}
	}
}
