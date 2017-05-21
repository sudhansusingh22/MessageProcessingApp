package com.jpm.msg.prc;

import junit.framework.Assert;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.xml.sax.SAXParseException;

import com.jpm.msg.prc.controller.MessageController;

// TODO: Auto-generated Javadoc
/**
 * The Class TestMessage.
 */
public class MessageTest  {
	
	/**
	 * Test 1.
	 * @throws FileNotFoundException 
	 */
	@Test
	public final void checkXMLReadTest() throws FileNotFoundException {
		//test xml read
		MessageController msgContr = new MessageController();
		msgContr.fileName = "/test1.xml";
		Assert.assertEquals(1, msgContr.process().size());
	}
	
	/**
	 * Test 2.
	 * @throws FileNotFoundException 
	 */
	@Test
	public final void checkSalePriceTest() throws FileNotFoundException {
		//test xml read
		MessageController msgContr = new MessageController();
		msgContr.fileName = "/test2.xml";
		Assert.assertEquals("18.90", msgContr.process().get(1).getPrice().toString());
	}
	
	/**
	 * Test 3.
	 * @throws FileNotFoundException 
	 */
	@Test
	public final void checkSaleQtyTest() throws FileNotFoundException {
		//test xml read
		MessageController msgContr = new MessageController();
		msgContr.fileName = "/test3.xml";
		Assert.assertEquals("1", msgContr.process().get(1).getQty().toString());
	}
	
	@Test(expected=FileNotFoundException.class)
	public void testfileNotFoundException() throws FileNotFoundException {
		MessageController msgContr = new MessageController();
		msgContr.fileName = "";
		msgContr.process();
	}
	
}
