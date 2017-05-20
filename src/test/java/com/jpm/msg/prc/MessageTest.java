package com.jpm.msg.prc;

import junit.framework.Assert;
import org.junit.Test;

import com.jpm.msg.prc.controller.MessageController;

// TODO: Auto-generated Javadoc
/**
 * The Class TestMessage.
 */
public class MessageTest  {
	
	/**
	 * Test 1.
	 */
	@Test
	public final void checkXMLReadTest() {
		//test xml read
		MessageController msgContr = new MessageController();
		msgContr.fileName = "/test1.xml";
		Assert.assertEquals(1, msgContr.process().size());
	}
	
	/**
	 * Test 2.
	 */
	@Test
	public final void checkSalePriceTest() {
		//test xml read
		MessageController msgContr = new MessageController();
		msgContr.fileName = "/test2.xml";
		Assert.assertEquals("18.90", msgContr.process().get(1).getPrice().toString());
	}
	
	/**
	 * Test 3.
	 */
	@Test
	public final void checkSaleQtyTest() {
		//test xml read
		MessageController msgContr = new MessageController();
		msgContr.fileName = "/test3.xml";
		Assert.assertEquals("1", msgContr.process().get(1).getQty().toString());
	}
}
