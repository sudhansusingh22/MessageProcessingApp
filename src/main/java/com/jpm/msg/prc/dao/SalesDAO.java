/**
 * 
 */
package com.jpm.msg.prc.dao;
import java.util.ArrayList;
import java.util.List;

import com.jpm.msg.prc.model.Sale;
// TODO: Auto-generated Javadoc

/**
 * The Class SalesDAO.
 *
 * @author sud
 */

public class SalesDAO {
	
	/** The sales. */
	private List<Sale> allSales = new ArrayList<>();
	
	/**
	 * Gets the sales.
	 *
	 * @return the sales
	 */
	public List<Sale> getAllSales() {
		return allSales;
	}
}
