package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import classes.User;

import pojo.ExtResults;
import pojo.Results;

import dao.AbstractFacadeDAO;
import dao.Facade;

public class StatForAdmin implements Controller {
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String uri = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		ModelAndView modelAndView = new ModelAndView(
				"/WEB-INF/jsp/statForAdmin.jsp");
		
		String login = (String) request.getSession().getAttribute("login");
		AbstractFacadeDAO facade = new Facade();
		List<User> users = new ArrayList<User>();
		users = facade.getUserList(uri+"\\users.xml");
		List<ExtResults> results = new ArrayList<ExtResults>();
		for (User user: users){
			if (facade.getUserResults(user.getLogin(), uri+"\\results.xml").size()!=0) {
				for (Results result: facade.getUserResults(user.getLogin(), uri+"\\results.xml")) {
				ExtResults res = new ExtResults();
				res.setPib(user.getSurname()+" "+user.getFirstName()+" "+user.getMiddleName());
				res.setGroup(user.getGroup());
				res.setTest(result.getTest());
				res.setDate(result.getDate());
				res.setLogin(user.getLogin());
				res.setBall(result.getPersents());
				res.setMark(result.getMark());
				results.add(res);
				}
			}			
		}
		facade.getUserResults(login, uri);		
		modelAndView.addObject("results", results);
		return modelAndView;
	}
}

