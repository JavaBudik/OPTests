package other;

import java.io.FileWriter;
import java.io.IOException;


public class ResultsToXML {
	String login;
	String testName;
	Integer mark;
	Integer ball;
	String date;
	
	public ResultsToXML(String login, String testName, Integer mark,
			Integer ball, String date) {
		super();
		this.login = login;
		this.testName = testName;
		this.mark = mark;
		this.ball = ball;
		this.date = date;
	}


	public void xmlWrite(String uri) {
		
		try {
			FileUtil util = new FileUtil();
			util.removeLineFromFile(uri, "</info>");
			
			FileWriter file = new FileWriter(uri, true);
			System.out.println(uri);
			int yourMark = (mark*100/ball);
			file.write("\t<result login=\"" + login + "\" test=\"" + testName);
			file.write("\" mark=\""+yourMark);
			file.write("\" ball=\""+mark+" ç "+ball+"\"");
			file.write(" date=\""+date);
			file.write("\"/>\n");
			file.write("\n</info>");	
			file.flush();
			file.close();
		} catch (IOException e) {
			System.out.println("Error opening the file users.xml"
					+ e.getMessage());
		}	
	}
}
