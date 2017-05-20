/**
 * 
 */
package com.jpm.msg.prc.controller;

/**
 * @author sud
 *
 */
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.jpm.msg.prc.model.Operation;
import com.jpm.msg.prc.utility.Constant;
import com.jpm.msg.prc.model.Message;

/**
 * The Class MessageReader.
 */
public class MessageController {
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(MessageController.class);
	
	/**
	 * Process.
	 *
	 * @return the list of messages
	 */
	public List<Message> process() {
		// list of message to store messages from the XML parsing
		List<Message> messages = new ArrayList<Message>();
		
		// Default base class for SAX2 event handlers. 
		
		DefaultHandler handler = new DefaultHandler() {
			// Quantity Flag
			boolean quantityFlag = false;
			// Operation Flag
			boolean operationFlag = false;
			Message message;
			/**
			 * startElement
			 * @param uri
			 * @param localName
			 * @param qName
			 * @param attributes
			 */
			public void startElement(String uri, String localName,String qName,
		                Attributes attributes) throws SAXException {
				if (qName.equalsIgnoreCase(Constant.MESSAGE)) {
					log.info("Creating new message." );
					message = new Message();
					message.setProductType(attributes.getValue(Constant.PRODUCTTYPE));
					message.setPrice(new BigDecimal(attributes.getValue(Constant.PRICE)));
				}
				if (qName.equalsIgnoreCase(Constant.QUANTITY)) {
					quantityFlag = true;
				}
				if (qName.equalsIgnoreCase(Constant.OPERATION)) {
					operationFlag = true;
				}
			}
			/**
			 * endElement
			 * @param uri
			 * @param localName
			 * @param qName
			 */
			public void endElement(String uri, String localName,
				String qName) throws SAXException {
				log.info("adding message to list." );
				if (qName.equalsIgnoreCase(Constant.MESSAGE))
					messages.add(message);
			}
			/**
			 * characters
			 * @param ch[]
			 * @param start
			 * @param length
			 */
			public void characters(char ch[], int start, int length) throws SAXException {
				// if quantity is set then set the quantity for message as well
				if (quantityFlag) {
					message.setQty(new BigDecimal(new String(ch, start, length)));
					quantityFlag = false;
				}
				// if quantity is set then set the quantity for message as well

				if (operationFlag) {
					message.setOperation(Operation.valueOf(new String(ch, start, length).toUpperCase()));
					operationFlag = false;
				}
			}
		};
	
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		try {
			log.info("Creating a SAXParser." );
			SAXParser saxParser = saxFactory.newSAXParser();
			// get input stream
			log.info("Reading input data file." );
			InputStream in = getClass().getResourceAsStream(Constant.INPUTDATAFILE); 
			saxParser.parse(in,handler);
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		    log.log( Level.FATAL, e.toString(), e);
		} 
		catch (IOException e) {
			e.printStackTrace();
		    log.log( Level.FATAL, e.toString(), e);
		}
		catch(Exception e) {
			e.printStackTrace();
		    log.log( Level.FATAL, e.toString(), e);
		}
	return messages;
	}
}