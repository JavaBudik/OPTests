package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import pojo.Questions;
import pojo.Test;
import dao.AbstractFacadeDAO;
import dao.Facade;

public class GetTestController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int ball = 0;

		ModelAndView modelAndView = new ModelAndView("/WEB-INF/jsp/getTest.jsp");
		System.out.println(request.getCharacterEncoding());
		String xml = request.getParameter("xml");

		request.getSession().setAttribute("mark", 0);
		request.getSession().setAttribute("index", 0);
		request.getSession().setAttribute("xml", xml);

		AbstractFacadeDAO facade = new Facade();
		String uri = request.getSession().getServletContext().getRealPath(
				"/WEB-INF/" + xml);
		Test test = facade.getTest(uri);
		Integer numberOfQuestions = Integer.parseInt(test
				.getNumberOfQuestions());
		Test realTest = new Test();
		realTest.setName(test.getName());
		realTest.setNumberOfQuestions(test.getNumberOfQuestions());
		List<Questions> quest = new ArrayList<Questions>();
		List<Integer> numbers = new ArrayList<Integer>();
		int i = 0;
		while (i < numberOfQuestions) {
			int number = (int) ((0.001 + Math.random()) * 1000);
			while (number > Integer.parseInt(test.getNumberOfQuestions())){
				number-=Integer.parseInt(test.getNumberOfQuestions());
			}
			if (!numbers.contains(number)) {
				numbers.add(new Integer(number));
				Questions question = test.getQuestion().get(number-1);
				quest.add(question);
				i++;
			} else {	
			}
		}
		realTest.setQuestion(quest);
		
		for (Questions question : realTest.getQuestion()) {
			ball += (int) Integer.parseInt(question.getLevel());
			System.out.println(question.getName());
		}
		request.getSession().setAttribute("test", realTest);
		request.getSession().setAttribute("lastQuestion",
				realTest.getQuestion().size());
		modelAndView.addObject("maxBall", ball);
		modelAndView.addObject("testUrl", xml);
		modelAndView.addObject("test", test);

		return modelAndView;
	}
}
