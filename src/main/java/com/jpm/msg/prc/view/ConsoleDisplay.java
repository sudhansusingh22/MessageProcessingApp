/**
 * 
 */
package com.jpm.msg.prc.view;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

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
	public static void reportAfterEach10Sales (List<Sale> sales, int count) {
		try{
			HashMap<String,Sale> res = new HashMap<String,Sale>();
			BigDecimal totalValue = BigDecimal.ZERO;
			for (Sale sale : sales) {
				String productType = sale.getProductType();
				Sale totalSale = res.get(productType);
				BigDecimal value = sale.getQty().multiply(sale.getPrice());
				totalValue = totalValue.add(value);
				if (totalSale!=null) {
					totalSale.setQty(totalSale.getQty().add(sale.getQty()));
					totalSale.setPrice(totalSale.getPrice().add(value));
				} else {
					totalSale= new Sale(productType, value, sale.getQty());
				}
				res.put(productType, totalSale);
			}
			
			System.out.println(">>> Report after "+ count + " sales: "+ "\n");
			System.out.println(" ******************************************* ");
			System.out.println("|       Product Name|       Price|  Quantity|");
			System.out.println("|*******************|************|**********|");
			for (Sale sale: res.values()) {
				System.out.println(sale);
			}
			System.out.println("|-------------------|------------|----------|");
			System.out.println("|        Total Sales|"+String.format("%1$12s", totalValue.toString())+"|          |");
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
	public static void reportAfter50Sales (List<Adjustment> adjustements) {
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
