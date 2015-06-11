package classes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Reg2 implements Controller {

	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("Windows-1251");
		System.out.println("loooogiiin"+req.getParameter("login"));
		if (req.getParameter("login").equals("Різниця")) {
			
			return new ModelAndView("redirect:index.jsp");
		} else
		return new ModelAndView("redirect:regSuccess.jsp");
	}

}
