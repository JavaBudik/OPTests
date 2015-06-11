package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import pojo.Answers;
import pojo.Questions;
import pojo.Test;

public class testController implements Controller { 
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.getSession().setAttribute("startTime", getDateTime());
		Integer index = (Integer) (request.getSession().getAttribute("index"));
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/jsp/test.jsp");
		String xml = (String) request.getSession().getAttribute("xml");
//		AbstractFacadeDAO facade = new Facade();
//		String uri = request.getSession().getServletContext().getRealPath("/WEB-INF/"+xml);
//		Test test = facade.getTest(uri);
		Test test = (Test) request.getSession().getAttribute("test");
		Questions question = test.getQuestion().get(index);
		for (Questions q : test.getQuestion()){
			System.out.println(q.getName());
		}
		Integer number = 0;
		for (Answers ans: question.getAnswers()){
			number += Integer.parseInt(ans.getBal());
		}
		modelAndView.addObject("testUrl", xml);
		modelAndView.addObject("number", number);
		modelAndView.addObject("question", question);
		modelAndView.addObject("ball", question.getLevel());
		if (number == 1){
			modelAndView.addObject("button", "radio");
		} else {
			modelAndView.addObject("button", "checkbox");
		}
		return modelAndView;
	}
	
	private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
