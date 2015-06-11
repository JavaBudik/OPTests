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

import pojo.Answers;
import pojo.Questions;
import pojo.Test;

/**
 * A sample SAX writer. This sample program illustrates how to register a SAX
 * DocumentHandler and receive the callbacks in order to print a document that
 * is parsed.
 */

public class SaxTest extends DefaultHandler {
	private Test test = new Test();
	private List<Questions> questions = new ArrayList<Questions>();
	private List<Answers> answers = new ArrayList<Answers>();
	private String questionName;
	private String questionBal;
	private int count;
	private int j = 0;
	private int questionIndex = -1;
	private boolean check = false;

	private void parseURI(String uri) {
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

		if (rawName.equalsIgnoreCase("test")) {
			test.setName(attrs.getValue(0));
			test.setNumberOfQuestions(attrs.getValue(1));
		} else if (rawName.equalsIgnoreCase("question")) {
			questionName = attrs.getValue(0);
			questionBal = attrs.getValue(1);
			count = Integer.parseInt(attrs.getValue(2));
			check = true;
			questionIndex++;
		} else {
			if (attrs != null && check == true) {
				Answers ans = new Answers();
				ans.setName(attrs.getValue(1));
				ans.setBal(attrs.getValue(0));
				answers.add(ans);
				j++;
			}
			if (j == count) {
				check = false;
				Questions quest = new Questions();
				List<Answers> s = new ArrayList<Answers>();
				for (Answers aa : answers.subList((answers.size()- count),
						answers.size())) {
					s.add(aa);
				}
				quest.setAnswers(s);
				quest.setName(questionName);
				quest.setLevel(questionBal);
				quest.setCount(count);
				questions.add(quest);
				j = 0;
			}
		}
	} // startElement(String,AttributeList)

	/** End document. */
	public void endDocument() {
		test.setQuestion(questions);
	} // endDocument()

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

	public Test getTest(String url) {
		parseURI(url);
		return test;
	}
}
