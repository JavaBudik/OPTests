package other;

import pojo.Answers;
import pojo.Questions;
import pojo.Results;
import pojo.Test;
import classes.User;
import dao.Facade;

public class Start {
	/** Main program entry point. */
	public static void main(String argv[]) {
//		SaxUsers s2 = new SaxUsers();
//		for (User s: s2.getUsers()){
//			System.out.println(s.getFirstName()+ " " + s.getMiddleName() + " "+s.getSurname());
//			System.out.println(s.getLogin()+ " " + s.getPassword() + " "+s.getGroup());
//		}
		
//		Facade f = new Facade();
//		for (Results ss : f.getUserResults("login1")) {
//			System.out.println(ss.getTest());
//		}
		
		// SaxResults s2 = new SaxResults();
		// for(Results ss: s2.getRes()){
		// System.out.println(ss.getLogin()+ " "+ ss.getTest() + " " +
		// ss.getMark() + " " + ss.getPersents() + " " + ss.getDate());
		// }
		//	    
		// SaxTestList s1 = new SaxTestList();
		// for(TestList ss: s1.getList()){
		// System.out.println(ss.getName()+ " "+ ss.getLink());
		// }

		SaxTest s3 = new SaxTest();
		
		Test test = s3.getTest("test1.xml");
		System.out.println(test.getName());
		for (Questions quest : test.getQuestion()) {
			System.out.println(quest.getName());
			for (Answers an: quest.getAnswers()) {
				System.out.println(an.getName());
			}
		}

	} // main(String[])

}
