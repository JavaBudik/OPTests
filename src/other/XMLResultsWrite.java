package other;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * @author karthikeyanc
 */
public class XMLResultsWrite {

	public static void main(String[] args) throws Exception {
		String xmlFilePath = "c:\\results.xml";

		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(xmlFilePath);
		
		Element child = doc.createElement("result");
		child.setAttribute("login", "x");
		child.setAttribute("test", "x");
		child.setAttribute("mark", "x");
		child.setAttribute("persent", "x");
		child.setAttribute("data", "x");
		System.out.println("Ss");
		Transformer t = TransformerFactory.newInstance().newTransformer();
		Result result = new StreamResult(new File(xmlFilePath));
		Source source = new DOMSource(doc);
		t.transform(source, result);

	}

	private static void replaceValue(Document doc, String tagName,
			String replaceValue) {
		NodeList nodeList = doc.getElementsByTagName(tagName);
		Node node = nodeList.item(0);
		node.getFirstChild().setNodeValue(replaceValue);
	}
}