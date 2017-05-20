/**
 * 
 */
package com.jpm.msg.prc.model;
import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class Sale.
 *
 * @author sud
 */

public class Sale {
		
		/**
		 * Instantiates a new sale.
		 *
		 * @param productType the product type
		 * @param price the price
		 * @param qty the qty
		 */
		public Sale(String productType, BigDecimal price, BigDecimal qty) {
		super();
		this.productType = productType;
		this.price = price;
		this.qty = qty;
	}
		
		/** The product type. */
		private String productType;
		
		/** The price. */
		private BigDecimal price;
		
		/** The qty. */
		private BigDecimal qty=BigDecimal.ONE;

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
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString () {
			return "|"+String.format("%1$19s", getProductType())+"|"+String.format("%1$12s",getPrice().toString())+"|"+String.format("%1$10s",getQty().toString())+"|";
		}
	}