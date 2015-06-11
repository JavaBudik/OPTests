package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import other.ResultsToXML;
import pojo.Questions;
import pojo.Test;

public class testResultController implements Controller { 
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String xml = (String) request.getSession().getAttribute("xml");
		String date = (String) request.getSession().getAttribute("startTime");
		String login = (String) request.getSession().getAttribute("login");
		System.out.println(login);
//		AbstractFacadeDAO facade = new Facade();
//		String uri = request.getSession().getServletContext().getRealPath("/WEB-INF/"+xml);
//		Test test = facade.getTest(uri);
		Test test = (Test) request.getSession().getAttribute("test");
		int ball = 0;
		for (Questions question : test.getQuestion()) {
				ball += (int) Integer.parseInt(question.getLevel());
		}
		
		ModelAndView modelAndView = null;
		
		Integer mark = (Integer)(request.getSession().getAttribute("mark"));
		Integer index = (Integer) (request.getSession().getAttribute("index"));
		index++; 
		
		modelAndView = new ModelAndView("/WEB-INF/jsp/testResults.jsp");
		
		request.getSession().setAttribute("mark", mark);
		request.getSession().setAttribute("index", index);
		request.getSession().setAttribute("maxBall", ball);
		int yourMark = (mark*100/ball);
		request.getSession().setAttribute("yourMark", yourMark);
		String uri2 = request.getSession().getServletContext().getRealPath("/WEB-INF/results.xml");
		saveResultsToXML(date, mark, login, test.getName(), ball, uri2);
		return modelAndView;
	}
	
	private void saveResultsToXML(String date, Integer mark, String login, String testName, Integer ball, String uri){
		ResultsToXML obj1 = new ResultsToXML(login, testName, mark, 
				ball, date);
		obj1.xmlWrite(uri);	
	}
}
