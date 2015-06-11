package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class LogOut extends SimpleFormController{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse arg1)
			throws Exception {
		
		request.getSession().setAttribute("login", null);
		request.getSession().invalidate();
		return new ModelAndView("redirect:login.htm");
	
	}
}
