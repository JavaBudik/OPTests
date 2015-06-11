package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AddLevel2Validator implements Validator {
	
	private static final String BALS = "[0-9]{1,}";
	//private static final String QUEST = "{1,}";
		
	
	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return clazz.equals(RegCommand.class);
	}

	public void validate(Object command, Errors errors) {
		RegCommand regCommand = (RegCommand) command;
		ValidationUtils.rejectIfEmpty(errors, "login", null, "Поле не може бути пустим");
		ValidationUtils.rejectIfEmpty(errors, "var1", null, "Поле не може бути пустим");
		ValidationUtils.rejectIfEmpty(errors, "var2", null, "Поле не може бути пустим");
		ValidationUtils.rejectIfEmpty(errors, "level", null, "Поле не може бути пустим");
				
		if(!regCommand.getLevel().matches(BALS)) {
			errors.rejectValue("level", null, "Кількість балів - " +
					" ціле число");
		}		
	}

}
