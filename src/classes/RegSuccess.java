package classes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class RegSuccess extends SimpleFormController {
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		RegCommand regCommand = (RegCommand) command;
		String login = regCommand.getLogin();
		String password = regCommand.getPassword();	
		return new ModelAndView("redirect:login.htm");
	}
	

}
