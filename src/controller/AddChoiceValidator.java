package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AddChoiceValidator implements Validator {
	
	private static final String BALS = "[0-9]{1,}";
	//private static final String QUEST = "{1,}";
		
	
	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return clazz.equals(RegCommand.class);
	}

	public void validate(Object command, Errors errors) {
		RegCommand regCommand = (RegCommand) command;
		ValidationUtils.rejectIfEmpty(errors, "login", null, "Поле не може бути пустим");
		ValidationUtils.rejectIfEmpty(errors, "correct", null, "Поле не може бути пустим");
						
		if(!regCommand.getCorrect().matches(BALS)) {
			errors.rejectValue("correct", null, "Кількість питань - " +
					" ціле число");
		}		
	}

}
