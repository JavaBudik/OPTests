package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.AbstractFacadeDAO;
import dao.Facade;

public class UserStatController implements Controller {


	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String uri = request.getSession().getServletContext().getRealPath("/WEB-INF/results.xml");
		request.getSession().setAttribute("mark", null);
		request.getSession().setAttribute("index", null);
		request.getSession().setAttribute("xml", null);
		request.getSession().setAttribute("lastQuestion", null);
		request.getSession().setAttribute("maxBall", null);
		ModelAndView modelAndView = new ModelAndView(
				"/WEB-INF/jsp/userStat.jsp");
		String login = (String) request.getSession().getAttribute("login");
		AbstractFacadeDAO facade = new Facade();
		modelAndView.addObject("results", facade.getUserResults(login, uri));
		return modelAndView;
	}
}
