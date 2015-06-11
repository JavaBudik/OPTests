package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;

import pojo.ExtResults;
import pojo.Results;
import classes.User;
import dao.AbstractFacadeDAO;
import dao.Facade;

public class AllUsersController implements Controller {
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String uri = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		ModelAndView modelAndView = new ModelAndView(
				"/WEB-INF/jsp/infoAll.jsp");		
		AbstractFacadeDAO facade = new Facade();
		List<User> users = new ArrayList<User>();
		users = facade.getUserList(uri+"\\users.xml");				
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	
	

}
