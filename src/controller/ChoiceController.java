package controller;

import java.io.File;
import java.io.FileWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import dao.Facade;

import other.FileUtil;

public class ChoiceController extends SimpleFormController {
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		RegCommand regCommand = (RegCommand) command;
		String testName = regCommand.getLogin();
		System.out.println("correct = "+regCommand.getCorrect());
		Integer kilkist = Integer.valueOf(regCommand.getCorrect());
		System.out.println("correctInt = "+kilkist);
		request.getSession().setAttribute("testname", testName);
				
		//String testname = request.getSession().getAttribute("testname").toString();
		String uri = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		System.out.println("testnamereal=  "+uri+"\\"+testName+".xml");
		//
		Facade facade = new Facade();
		Integer number = facade.getTestList(uri+"/tests.xml").size()+1;
		while (new File(uri+"/test"+number+".xml").exists()) {
			number++;
		}
		request.getSession().setAttribute("number", number);
		//
		File xmlfile = new File (uri+"\\test"+number+".xml");
		xmlfile.createNewFile();
		FileWriter xmlwrite = new FileWriter (uri+"\\test"+number+".xml", true);
		xmlwrite.write("<?xml version=\"1.0\" encoding=\"Windows-1251\"?>\n");
		//<test name="Dogs" numberOfQuestions="7">;
		xmlwrite.write("<test name=\""+testName+"\" numberOfQuestions=\""+kilkist+"\">\n");
		xmlwrite.write("</test>");
		xmlwrite.flush();
		xmlwrite.close();
		FileUtil util = new FileUtil();
		util.removeLineFromFile(uri+"\\"+"tests.xml", "</tests>");
		FileWriter xmlfile2 = new FileWriter (uri+"\\"+"tests.xml", true);
		xmlfile2.write("      <test name=\""+testName+"\""+" link=\"test"+number+".xml\"/>\n");
		xmlfile2.write("</tests>");
		xmlfile2.flush();
		xmlfile2.close();
		return new ModelAndView("redirect:addLevel1.htm");
	}
}
