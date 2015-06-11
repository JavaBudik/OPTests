package classes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import dao.AbstractFacadeDAO;
import dao.Facade;

import other.SaxUsers;

public class LogController extends SimpleFormController {
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws ServletException {
		Boolean valid = false;
		RegCommand regCommand = (RegCommand) command;
		String login = regCommand.getLogin();
		String password = regCommand.getPassword();
		System.out.println(login+" "+password);
		AbstractFacadeDAO facade = new Facade();
		//SaxUsers listUsers = new SaxUsers();
		for (User list: facade.getUserList(password)){
			System.out.println(list.getLogin()+" "+list.getPassword());
			if ((list.getLogin().equals(login)) /*&& (list.getPassword()==password)*/) {
				System.out.println("true");
				
				valid=true;
			}				
		}
		if (valid) {
			request.getSession().setAttribute("login", login);
			return new ModelAndView("redirect:testList.htm");
		} else
			return new ModelAndView("redirect:register.htm");
		
		
	}

}
