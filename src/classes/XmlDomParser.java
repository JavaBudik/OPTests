package classes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//import org.xml.sax.helpers.DefaultHandler;

public class XmlDomParser {
	private String login;
	public XmlDomParser() {
		System.out.println("XML DOM started");
	}
	public XmlDomParser(String login) {
		this.login = login;
		System.out.println("XML DOM started");
	}
	/** name - line name in xml.	 */
	  private String name = null;
	  
	  	/** valueOfXML - line attribute in XML. */
	  private String valueOfXML = null;
	  /** HaspMap with line name and line attribute. */
	  User user;

	private List<User> users = new ArrayList<User>();
	public List<User> getUsers() {
		return users;
	}
	public final void parseURI(final String uri) {
	    Document doc = null;
	    try {
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      dbf.setIgnoringElementContentWhitespace(true);
	      DocumentBuilder db = dbf.newDocumentBuilder();
	      doc = db.parse(uri);
	      if (doc != null) {
	    	  printDomTree(doc);
	    	  System.out.println("!!!!!!!!!!!!!!!11= "+doc);
	    	  Element elem = doc.getDocumentElement();
	    	  
	    	  System.out.println("!!!!!!!!!!!!!!!22= "+elem.getFirstChild());
	    	  String password = elem.getAttribute("password");
	    	  System.out.println("!!!!!!!!!!!!!!!33= ");
	    	  NodeList nl  = elem.getElementsByTagName("name");	 
	    	  System.out.println("!!!!!!!!!!!!!!!44 "+nl);
	    	  Node n = nl.item(0);
	    	  System.out.println("!!!!!!!!!!!!!!!55= ");
	    	  NamedNodeMap nnm = n.getAttributes();
	    	  System.out.println("!!!!!!!!!!!!!!!66= ");
	    	  String firstName = nnm.item(0).getNodeValue();
	    	  System.out.println("!!!!!!!!!!!!!!!name= "+firstName);
	    	  User user = new User();
	    	  user.setFirstName(firstName);
	    	  setUser(user);
	      }
	    } catch (Exception e) {
	      System.err.println("Sorry, an error occurred: " + e);
	    }
	  }
	/** Prints the specified node, recursively. 
	   * @param node - node
	   */
	  public final void printDomTree(final Node node) {

	    int type = node.getNodeType();
	    switch (type) {
	      // print the document element
	      case Node.DOCUMENT_NODE: 
	          printDomTree(((Document) node).getDocumentElement());
	          break;
	      // print element with attributes
	      case Node.ELEMENT_NODE: 
	          name = node.getNodeName();
	          NamedNodeMap attrs = node.getAttributes();
	          for (int i = 0; i < attrs.getLength(); i++) {
	        	  printDomTree(attrs.item(i));
	          }
	          NodeList children = node.getChildNodes();
	          if (children != null) {
	            int len = children.getLength();
	            for (int i = 0; i < len; i++) {
	              printDomTree(children.item(i));
	              
	            }
	          }
	         break;
	      // Print attribute nodes
	      case Node.ATTRIBUTE_NODE:
	          String value = ((Attr) node).getValue();
	          valueOfXML = value;
	          break;
	      default:
				break;
	    }
	    /*if ((name != null) && (valueOfXML != null)) {
	    	hashMap.put(name, valueOfXML);
	    	name = null;
	    	valueOfXML = null;
	    } */
	    }
	  public User getUser() {
		  return user;
	  }
	  public void setUser(User user) {
		  this.user = user;
	  }
      


}
