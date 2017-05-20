/**
 * 
 */
package com.jpm.msg.prc.model;
import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class Message.
 *
 * @author sud
 */

public class Message {
	
	/** The product type. */
	private String productType;
	
	/** The price. */
	private BigDecimal price;
	
	/** The qty. */
	private BigDecimal qty=BigDecimal.ONE;
	
	/** The command. */
	private Operation command=Operation.SALE;
	
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
	 * Gets the price.
	 *
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	/**
	 * Gets the qty.
	 *
	 * @return the qty
	 */
	public BigDecimal getQty() {
		return qty;
	}
	
	/**
	 * Sets the qty.
	 *
	 * @param qty the new qty
	 */
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	
	/**
	 * Gets the command.
	 *
	 * @return the command
	 */
	public Operation getCommand() {
		return command;
	}
	
	/**
	 * Sets the command.
	 *
	 * @param command the new command
	 */
	public void setCommand(Operation command) {
		this.command = command;
	}	
	
}
