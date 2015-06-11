package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import pojo.ExtResults;
import pojo.Results;

import classes.User;
import dao.AbstractFacadeDAO;
import dao.Facade;

public class SearchController extends SimpleFormController {
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		RegCommand regCommand = (RegCommand) command;
		String uri = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		Integer what = (Integer)request.getAttribute("what");
		String correct = regCommand.getCorrect();
		ModelAndView modelAndView = new ModelAndView(
		"/WEB-INF/jsp/statForAdmin.jsp");
		if (what==1) {
			String surname = regCommand.getSurname();
			AbstractFacadeDAO facade = new Facade();
			List<User> users = new ArrayList<User>();
			users = facade.getUserList(uri+"\\users.xml");
			List<ExtResults> results = new ArrayList<ExtResults>();
			for (User user: users){
				Boolean temp = false;
				if (correct!=null) {
					temp = user.getSurname().equalsIgnoreCase(surname);
				} else temp = user.getSurname().equals(surname);
				
				if (facade.getUserResults(user.getLogin(), uri+"\\results.xml").size()!=0&&temp) {
					for (Results result: facade.getUserResults(user.getLogin(), uri+"\\results.xml")) {
					ExtResults res = new ExtResults();
					res.setPib(user.getSurname()+" "+user.getFirstName()+" "+user.getMiddleName());
					res.setTest(result.getTest());
					res.setGroup(user.getGroup());
					res.setDate(result.getDate());
					res.setLogin(user.getLogin());
					res.setBall(result.getPersents());
					res.setMark(result.getMark());
					results.add(res);					
					}
				}			
			}
			modelAndView.addObject("results", results);
		}
		
		if (what==2) {
			String group = regCommand.getGroup();
			AbstractFacadeDAO facade = new Facade();
			List<User> users = new ArrayList<User>();
			users = facade.getUserList(uri+"\\users.xml");
			List<ExtResults> results = new ArrayList<ExtResults>();
			for (User user: users){
				Boolean temp = false;
				if (correct!=null) {
					temp = user.getGroup().equalsIgnoreCase(group);
				} else temp = user.getGroup().equals(group);
				if (facade.getUserResults(user.getLogin(), uri+"\\results.xml").size()!=0&&temp) {
					for (Results result: facade.getUserResults(user.getLogin(), uri+"\\results.xml")) {
					ExtResults res = new ExtResults();
					res.setPib(user.getSurname()+" "+user.getFirstName()+" "+user.getMiddleName());
					res.setTest(result.getTest());
					res.setGroup(user.getGroup());
					res.setDate(result.getDate());
					res.setLogin(user.getLogin());
					res.setBall(result.getPersents());
					res.setMark(result.getMark());
					results.add(res);
					}
				}			
			}
			modelAndView.addObject("results", results);
		}
		
		if (what==3) {
			String testName = regCommand.getFirstName();
			AbstractFacadeDAO facade = new Facade();
			List<User> users = new ArrayList<User>();
			users = facade.getUserList(uri+"\\users.xml");
			List<ExtResults> results = new ArrayList<ExtResults>();
			for (User user: users){
				
				if (facade.getUserResults(user.getLogin(), uri+"\\results.xml").size()!=0) {
					for (Results result: facade.getUserResults(user.getLogin(), uri+"\\results.xml")) {
					String test = result.getTest().toLowerCase();
					testName.toLowerCase();
					if (test.contains(testName)||testName.contains(test)) {
					//if (result.getTest().equals(testName)) {
					ExtResults res = new ExtResults();
					res.setPib(user.getSurname()+" "+user.getFirstName()+" "+user.getMiddleName());
					res.setTest(result.getTest());
					res.setGroup(user.getGroup());
					res.setDate(result.getDate());
					res.setLogin(user.getLogin());
					res.setBall(result.getPersents());
					res.setMark(result.getMark());
					results.add(res);
					   }
					}
				}			
			}
			modelAndView.addObject("results", results);
		}
		
		if (what==4) {
			String testName = regCommand.getLevel1();
			String group = regCommand.getLevel2();
			AbstractFacadeDAO facade = new Facade();
			List<User> users = new ArrayList<User>();
			users = facade.getUserList(uri+"\\users.xml");
			List<ExtResults> results = new ArrayList<ExtResults>();
			for (User user: users){
				Boolean temp = false;
				if (correct!=null) {
					temp = user.getGroup().equalsIgnoreCase(group);
				} else temp = user.getGroup().equals(group);
				
				if (facade.getUserResults(user.getLogin(), uri+"\\results.xml").size()!=0&&temp) {
					for (Results result: facade.getUserResults(user.getLogin(), uri+"\\results.xml")) {
					String test = result.getTest().toLowerCase();
					testName.toLowerCase();
					if (test.contains(testName)||testName.contains(test)) {
					//if (result.getTest().equals(testName)) {
					ExtResults res = new ExtResults();
					res.setPib(user.getSurname()+" "+user.getFirstName()+" "+user.getMiddleName());
					res.setTest(result.getTest());
					res.setGroup(user.getGroup());
					res.setDate(result.getDate());
					res.setLogin(user.getLogin());
					res.setBall(result.getPersents());
					res.setMark(result.getMark());
					results.add(res);
					   }
					}
				}			
			}
			modelAndView.addObject("results", results);
		}
		
		return modelAndView;
	}
	@Override
	protected ModelAndView processFormSubmission(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		request.setAttribute("what", 0);
		String parametr = request.getParameter("searchBySurname");
		if (parametr != null && parametr.equals("Почати пошук")) {
			request.setAttribute("what", 1);
		}
		parametr = request.getParameter("searchByGroup");
		if (parametr != null && parametr.equals("Почати пошук")) {
			request.setAttribute("what", 2);
		}
		parametr = request.getParameter("searchByTest");
		if (parametr != null && parametr.equals("Почати пошук")) {
			request.setAttribute("what", 3);
		}
		parametr = request.getParameter("searchByTestAndGroup");
		if (parametr != null && parametr.equals("Почати пошук")) {
			request.setAttribute("what", 4);
		}
		return super.processFormSubmission(request, response, command, errors);
	}	

}
