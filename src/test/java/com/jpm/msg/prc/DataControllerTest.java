/*
 * 
 */
package com.jpm.msg.prc;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import com.jpm.msg.prc.controller.DataController;
import com.jpm.msg.prc.controller.MessageController;
import com.jpm.msg.prc.dao.AdjustmentDAO;
import com.jpm.msg.prc.dao.SalesDAO;
import com.jpm.msg.prc.model.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class TestDataController.
 */
public class DataControllerTest {
	
	/**
	 * Test 1.
	 * @throws FileNotFoundException 
	 */
	@Test
	public void checkSingleSaleTest() throws FileNotFoundException {
		SalesDAO salesDao = new SalesDAO();
		AdjustmentDAO adjustementsDao = new AdjustmentDAO();
		MessageController msgContr = new MessageController();
		msgContr.fileName = "/test1.xml";
		List <Message> allMessages = msgContr.process();
		DataController pr = new DataController(salesDao,adjustementsDao);
		for (Message message: allMessages) {
			pr.parse(message);
		}
		assertEquals(0, salesDao.getAllSales().size());
		assertEquals(1, adjustementsDao.getAllAdjustments().size());
		
	}
	
	/**
	 * Test 2.
	 * @throws FileNotFoundException 
	 */
	@Test
	public void checkAdjustmentSaleTest() throws FileNotFoundException {
		SalesDAO salesDao = new SalesDAO();
		AdjustmentDAO adjustementsDao = new AdjustmentDAO();
		MessageController msgContr = new MessageController();
		msgContr.fileName = "/test2.xml";
		List <Message> allMessages = msgContr.process();
		DataController pr = new DataController(salesDao,adjustementsDao);
		for (Message message: allMessages) {
			pr.parse(message);
		}
		assertEquals(1, salesDao.getAllSales().size());
		assertEquals(1, adjustementsDao.getAllAdjustments().size());
		
	}
	
	/**
	 * Test 3.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	@Test
	public void checkAdjustmentWithQtyTest() throws FileNotFoundException {
		SalesDAO salesDao = new SalesDAO();
		AdjustmentDAO adjustementsDao = new AdjustmentDAO();
		MessageController msgContr = new MessageController();
		msgContr.fileName = "/test3.xml";
		List <Message> allMessages = msgContr.process();
		DataController pr = new DataController(salesDao,adjustementsDao);
		for (Message message: allMessages) {
			pr.parse(message);
		}
		assertEquals(2, salesDao.getAllSales().size());
		assertEquals("41.75", adjustementsDao.getAllAdjustments().get(0).getTotalAfter().toString());
		assertEquals("35.55", adjustementsDao.getAllAdjustments().get(0).getTotalBefore().toString());

	}
}
