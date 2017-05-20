package com.jpm.msg.prc.model;
/**
 * @author sud
 *
 */
import java.math.BigDecimal;


// TODO: Auto-generated Javadoc
/**
 * The Class Adjustment.
 */
public class Adjustment {

	/** The total before. */
	private BigDecimal totalBefore;
	
	/** The total after. */
	private BigDecimal totalAfter;
	
	/** The total qty. */
	private BigDecimal totalQty;
	
	/** The command. */
	private Operation operation;
	
	/** The delta. */
	private BigDecimal delta;
	
	/** The product type. */
	private String productType;

	/**
	 * Instantiates a new adjustment.
	 *
	 * @param totalBefore the total before
	 * @param totalAfter the total after
	 * @param totalQty the total qty
	 * @param operation the operation
	 * @param delta the delta
	 * @param productType the product type
	 */
	public Adjustment(BigDecimal totalBefore, BigDecimal totalAfter, BigDecimal totalQty, Operation operation,
			BigDecimal delta, String productType) {
		this.totalBefore = totalBefore;
		this.totalAfter = totalAfter;
		this.totalQty = totalQty;
		this.operation = operation;
		this.delta = delta;
		this.productType = productType;
	}
	
	/**
	 * Gets the product type.
	 *
	 * @return the product type
	 */
	public String getProductType() {
		return productType;
	}
	
	/**
	 * Sets the product type.
	 *
	 * @param productType the new product type
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	/**
	 * Gets the total before.
	 *
	 * @return the total before
	 */
	public BigDecimal getTotalBefore() {
		return totalBefore;
	}
	
	/**
	 * Sets the total before.
	 *
	 * @param totalBefore the new total before
	 */
	public void setTotalBefore(BigDecimal totalBefore) {
		this.totalBefore = totalBefore;
	}
	
	/**
	 * Gets the total after.
	 *
	 * @return the total after
	 */
	public BigDecimal getTotalAfter() {
		return totalAfter;
	}
	
	/**
	 * Sets the total after.
	 *
	 * @param totalAfter the new total after
	 */
	public void setTotalAfter(BigDecimal totalAfter) {
		this.totalAfter = totalAfter;
	}
	
	/**
	 * Gets the total qty.
	 *
	 * @return the total qty
	 */
	public BigDecimal getTotalQty() {
		return totalQty;
	}
	
	/**
	 * Sets the total qty.
	 *
	 * @param totalQty the new total qty
	 */
	public void setTotalQty(BigDecimal totalQty) {
		this.totalQty = totalQty;
	}
	
	/**
	 * Gets the command.
	 *
	 * @return the command
	 */
	public Operation getOperation() {
		return operation;
	}
	
	/**
	 * Sets the command.
	 *
	 * @param command the new command
	 */
	public void setOperation(Operation command) {
		this.operation = command;
	}
	
	/**
	 * Gets the delta.
	 *
	 * @return the delta
	 */
	public BigDecimal getDelta() {
		return delta;
	}
	
	/**
	 * Sets the delta.
	 *
	 * @param delta the new delta
	 */
	public void setDelta(BigDecimal delta) {
		this.delta = delta;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString () {
		//return "Applied "+getOperation()+" "+getDelta()+" to "+getTotalQty()+ " "+ getProductType()+" and price changed from "+getTotalBefore()+ " to "+getTotalAfter();
		return "|"+String.format("%1$16s",getProductType()).toUpperCase() + "|"+String.format("%1$16s", getOperation())+"|"+String.format("%1$12s",getDelta())+"|"+String.format("%1$10s",getTotalQty())+"|"+String.format("%1$18s",getTotalBefore())+"|"+String.format("%1$16s",getTotalAfter())+"|";

	}
	
}
