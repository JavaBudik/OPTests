package other;

/*
 * (C) Copyright IBM Corp. 2003.  All rights reserved.
 *
 * US Government Users Restricted Rights Use, duplication or
 * disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * The program is provided "as is" without any warranty express or
 * implied, including the warranty of non-infringement and the implied
 * warranties of merchantibility and fitness for a particular purpose.
 * IBM will not be liable for any damages suffered by you as a result
 * of using the Program. In no event will IBM be liable for any
 * special, indirect or consequential damages or lost profits even if
 * IBM has been advised of the possibility of their occurrence. IBM
 * will not be liable for any third party claims against you.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import pojo.Results;


/**
 * A sample SAX writer. This sample program illustrates how to register a SAX
 * DocumentHandler and receive the callbacks in order to print a document that
 * is parsed.
 */

public class SaxResults extends DefaultHandler {
	private List<Results> res = new ArrayList<Results>();
	
	public void parseURI(String uri) {
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			File f = new File(uri);
			sp.parse(f, this);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/** Start element. */
	public void startElement(String namespaceURI, String localName,
			String rawName, Attributes attrs) {
		if(!rawName.equals("info")){
		if (attrs != null) {
				Results oneResult = new Results();
				oneResult.setLogin(attrs.getValue(0));
				oneResult.setTest(attrs.getValue(1));
				oneResult.setMark(attrs.getValue(2));
				oneResult.setPersents(attrs.getValue(3));
				oneResult.setDate(attrs.getValue(4));
				res.add(oneResult);
		}
		}
	} // startElement(String,AttributeList)

	// We don't implement the ignorableWhitespace event handler. //

	/** End document. */
	public void endDocument() {
		// No need to do anything.
	} // endDocument()

	/** Processing instruction. */
	public void processingInstruction(String target, String data) {
		System.out.print("<?");
		System.out.print(target);
		if (data != null && data.length() > 0) {
			System.out.print(' ');
			System.out.print(data);
		}
		System.out.print("?>");

	} // processingInstruction(String,String)

	//
	// ErrorHandler methods
	//

	/** Warning. */
	public void warning(SAXParseException ex) {
		System.err.println("[Warning] " + getLocationString(ex) + ": "
				+ ex.getMessage());
	}

	/** Error. */
	public void error(SAXParseException ex) {
		System.err.println("[Error] " + getLocationString(ex) + ": "
				+ ex.getMessage());
	}

	/** Fatal error. */
	public void fatalError(SAXParseException ex) throws SAXException {
		System.err.println("[Fatal Error] " + getLocationString(ex) + ": "
				+ ex.getMessage());
		throw ex;
	}

	/** Returns a string of the location. */
	private String getLocationString(SAXParseException ex) {
		StringBuffer str = new StringBuffer();

		String systemId = ex.getSystemId();
		if (systemId != null) {
			int index = systemId.lastIndexOf('/');
			if (index != -1)
				systemId = systemId.substring(index + 1);
			str.append(systemId);
		}
		str.append(':');
		str.append(ex.getLineNumber());
		str.append(':');
		str.append(ex.getColumnNumber());

		return str.toString();
	} // getLocationString(SAXParseException):String

	public List<Results> getRes(String uri) {
		parseURI(uri);
		return res;
	}
}
