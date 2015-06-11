package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.Facade;

public class TestListController implements Controller {

   
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView(
				"/WEB-INF/jsp/testList.jsp");
		request.getSession().setAttribute("mark", null);
		request.getSession().setAttribute("index", null);
		request.getSession().setAttribute("xml", null);
		request.getSession().setAttribute("lastQuestion", null);
		request.getSession().setAttribute("maxBall", null);
		String uri = request.getSession().getServletContext().getRealPath("/WEB-INF/tests.xml");
		Facade facade = new Facade();
		
		modelAndView.addObject("tests", facade.getTestList(uri));
		return modelAndView;
	}
}
