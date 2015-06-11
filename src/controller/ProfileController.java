package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.AbstractFacadeDAO;
import dao.Facade;

public class ProfileController implements Controller {


	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.getSession().setAttribute("mark", null);
		request.getSession().setAttribute("index", null);
		request.getSession().setAttribute("xml", null);
		request.getSession().setAttribute("lastQuestion", null);
		request.getSession().setAttribute("maxBall", null);
		ModelAndView modelAndView = new ModelAndView(
				"/WEB-INF/jsp/profile.jsp");
		String login = (String) request.getSession().getAttribute("login");
		String uri = request.getSession().getServletContext().getRealPath("/WEB-INF/users.xml");
		AbstractFacadeDAO facade = new Facade();
		
		modelAndView.addObject("user", facade.getUser(login, uri));
		return modelAndView;
	}
}
