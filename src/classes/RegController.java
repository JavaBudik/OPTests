package classes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


public class RegController extends SimpleFormController {

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		RegCommand regCommand = (RegCommand) command;
		String login = regCommand.getLogin();
		String password = regCommand.getPassword();
		String firstName = regCommand.getFirstName();
		String middleName = regCommand.getMiddleName();
		String surname = regCommand.getSurname();
		String vuz = regCommand.getVuz();
		String group = regCommand.getGroup();		
		System.out.println("login="+login);
		UserXmlWriter obj1 = new UserXmlWriter(login, password, firstName, 
				middleName, surname, vuz, group);
		obj1.xmlWrite();		
		return new ModelAndView("redirect:regsucc.htm");
	}


}

