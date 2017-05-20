/**
 * 
 */
package com.jpm.msg.prc.dao;
import java.util.ArrayList;
import java.util.List;

import com.jpm.msg.prc.model.Adjustment;

/**
 * @author sud
 *
 */

public class AdjustmentDAO {
	private List<Adjustment> adjustements = new ArrayList<Adjustment>();
	
	public List<Adjustment> getAdjustements() {
		return adjustements;
	}
}
