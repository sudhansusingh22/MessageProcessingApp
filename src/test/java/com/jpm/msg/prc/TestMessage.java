package com.jpm.msg.prc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jpm.msg.prc.controller.MessageController;

// TODO: Auto-generated Javadoc
/**
 * The Class TestMessage.
 */
public class TestMessage {
	
	/**
	 * Test 1.
	 */
	@Test
	public final void test1() {
		//test xml read
		MessageController msgContr = new MessageController();
		msgContr.fileName = "/test1.xml";
		assertEquals(1, msgContr.process().size());
	}
	
	/**
	 * Test 2.
	 */
	@Test
	public final void test2() {
		//test xml read
		MessageController msgContr = new MessageController();
		msgContr.fileName = "/test2.xml";
		assertEquals("18.90", msgContr.process().get(1).getPrice().toString());
	}
	
	/**
	 * Test 3.
	 */
	@Test
	public final void test3() {
		//test xml read
		MessageController msgContr = new MessageController();
		msgContr.fileName = "/test3.xml";
		assertEquals("32", msgContr.process().get(1).getQty().toString());
	}
}
