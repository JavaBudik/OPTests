package classes;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegValidator implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return clazz.equals(RegCommand.class);
	}

	public void validate(Object command, Errors errors) {
		RegCommand regCommand = (RegCommand) command;
		
	}

}
