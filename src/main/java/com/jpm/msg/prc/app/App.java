package com.jpm.msg.prc.app;

import com.jpm.msg.prc.controller.*;
import com.jpm.msg.prc.dao.AdjustmentDAO;
import com.jpm.msg.prc.dao.SalesDAO;
import com.jpm.msg.prc.model.*;
import com.jpm.msg.prc.view.ConsoleDisplay;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class App {
	private static final Logger log = Logger.getLogger(App.class);
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main (String[] args) {
		try{
			SalesDAO salesDao = new SalesDAO();
			AdjustmentDAO adjustementsDao = new AdjustmentDAO();
			List <Message> messages;
			MessageController mr = new MessageController();
			messages = mr.process();
			DataController pr = new DataController(salesDao,adjustementsDao);
			int i = 0;
			for (Message message: messages) {
				i++;
				pr.parse(message);
				if (i % 10 ==0){
					log.info("Reporting data after 10 sales" );
					ConsoleDisplay.reportAfterEach10Sales(salesDao.getAllSales());
				}
				if (i % 50 == 0){
					log.info("Reporting data after 50 sales" );
					ConsoleDisplay.reportAfter50Sales(adjustementsDao.getAllAdjustments());
				}
			}
		}catch( Exception ex ) {
			System.out.println(ex.toString());
		    log.log( Level.FATAL, ex.toString(), ex);
		}
	}
}
