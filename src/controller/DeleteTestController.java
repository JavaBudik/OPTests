package controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.Facade;

import other.FileUtil;
import pojo.Test;

public class DeleteTestController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("kkokokok"+request.getParameter("link"));
		String link = request.getParameter("link");
		String uri = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		FileUtil util = new FileUtil();
		Facade facade = new Facade();
		Test test = facade.getTest(uri+"\\"+link);
		String todel = "<test name=\""+test.getName()+"\" link=\""+link+"\"/>";
		util.removeLineFromFile(uri+"\\tests.xml", todel);
		File fileToDel = new File(uri+"\\"+link);
		fileToDel.delete();	
		System.out.println("link=="+link+"todel=="+todel);
		return new ModelAndView("redirect:alltest.htm");
	}

}
