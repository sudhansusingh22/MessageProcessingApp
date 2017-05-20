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
import com.jpm.msg.prc.model.Command;
import com.jpm.msg.prc.model.Message;

public class MessageReader {
	private static final Logger log = Logger.getLogger(MessageReader.class);
	public List<Message> process() {
		List<Message> messages = new ArrayList<Message>();
		
		DefaultHandler handler = new DefaultHandler() {
			boolean bqty = false;
			boolean bcommand = false;
			Message message;
			public void startElement(String uri, String localName,String qName,
		                Attributes attributes) throws SAXException {
				if (qName.equalsIgnoreCase("MESSAGE")) {
					message = new Message();
					message.setProductType(attributes.getValue("productType"));
					message.setPrice(new BigDecimal(attributes.getValue("price")));
				}
				if (qName.equalsIgnoreCase("QTY")) {
					bqty = true;
				}
				if (qName.equalsIgnoreCase("COMMAND")) {
					bcommand = true;
				}
			}
	
			public void endElement(String uri, String localName,
				String qName) throws SAXException {
				if (qName.equalsIgnoreCase("MESSAGE"))
					messages.add(message);
			}
	
			public void characters(char ch[], int start, int length) throws SAXException {
				if (bqty) {
					message.setQty(new BigDecimal(new String(ch, start, length)));
					bqty = false;
				}
	
				if (bcommand) {
					message.setCommand(Command.valueOf(new String(ch, start, length).toUpperCase()));
					bcommand = false;
				}
			}
		};
	
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			InputStream in = getClass().getResourceAsStream("/messages.xml"); 
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