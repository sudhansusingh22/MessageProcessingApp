/**
 * 
 */
package com.jpm.msg.prc.dao;
import java.util.ArrayList;
import java.util.List;

import com.jpm.msg.prc.model.Sale;
/**
 * @author sud
 *
 */

public class SalesDAO {
	private List<Sale> sales = new ArrayList<Sale>();
	
	public List<Sale> getSales() {
		return sales;
	}
}
