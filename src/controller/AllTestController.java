package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import pojo.TestList;

import dao.AbstractFacadeDAO;
import dao.Facade;

public class AllTestController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String uri = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		ModelAndView modelAndView = new ModelAndView(
				"/WEB-INF/jsp/alltests.jsp");	
		TestList test = new TestList();
		List<TestList> tests = new ArrayList<TestList>();
		AbstractFacadeDAO facade = new Facade();
		tests = facade.getTestList(uri+"\\tests.xml");		
		modelAndView.addObject("tests", tests);
		return modelAndView;
	}

}
