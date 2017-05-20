/**
 * 
 */
package com.jpm.msg.prc.dao;
import java.util.ArrayList;
import java.util.List;

import com.jpm.msg.prc.model.Adjustment;

// TODO: Auto-generated Javadoc
/**
 * The Class AdjustmentDAO.
 *
 * @author sud
 */

public class AdjustmentDAO {
	
	/** The adjustments. */
	private List<Adjustment> allAdjustments = new ArrayList<>();
	
	/**
	 * Gets the adjustments.
	 *
	 * @return the adjustments
	 */
	public List<Adjustment> getAllAdjustments() {
		return this.allAdjustments;
	}
}
