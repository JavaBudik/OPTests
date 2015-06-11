package classes;

//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserXmlWriter {
	String login;
	String password;
	String firstName;
	String middleName;
	String surname;
	String vuz;
	String group;
	public UserXmlWriter(String login, String password, String firstName,
			String middleName, String surname, String vuz, String group) {
		super();
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.surname = surname;
		this.vuz = vuz;
		this.group = group;
	}
	public void xmlWrite() {
		//PrintWriter outputStream = null;
		try {
			FileWriter file = new FileWriter("c:/users.xml", true);
			System.out.println("AAAAAAAAAAAAA");
			//file.write("<?xml version=\"1.0\" encoding=\"KOI8-R\"?>\n<users>\n");
			file.write("<user login=\"" + login + "\" password=\"" + password + "\">\n");
			file.write("   <name name=\""+firstName+"\"/>\n");
			file.write("   <middlename name=\""+middleName+"\"/>\n");
			file.write("   <surname attr=\""+surname+"\"/>\n");
			file.write("   <vuz attr=\""+vuz+"\"/>\n");
			file.write("   <group attr=\">"+group+"\"/>\n");	
			file.write("</user>\n");	
			file.flush();
			file.close();
		} catch (IOException e) {
			System.out.println("Error opening the file users.xml"
					+ e.getMessage());
		}
		System.out.println("AAAAAAAAAAAAA"+login);		
	}
}
