package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class checkController implements Controller {
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;

		Integer mark = (Integer) (request.getSession().getAttribute("mark"));
		Integer index = (Integer) (request.getSession().getAttribute("index"));
		Integer lastQuestion = (Integer) (request.getSession()
				.getAttribute("lastQuestion"));
		index++;
		if (index == lastQuestion) {
			modelAndView = new ModelAndView("testResults.htm");
		} else {
			modelAndView = new ModelAndView("test.htm");
		}
		String a[] = request.getParameterValues("answer");
		Integer ball = Integer.parseInt(request.getParameter("ball"));
		Integer number = Integer.parseInt(request.getParameter("number"));
		Integer count = 0;
		for (int i = 0; i < a.length; i++) {
			count += Integer.parseInt(a[i]);
		}
		
		if (count == number) {
			mark += ball;
		}
		
		request.getSession().setAttribute("mark", mark);
		request.getSession().setAttribute("index", index);
		return modelAndView;
	}

}
