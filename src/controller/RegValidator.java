package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;


public class RegValidator implements Validator {
	
	private static final String NAME = "^[A-ZА-ЯІЇЄ][a-zA-Zа-яА-ЯІіЇїЄє-]{1,}";
	private static final String LOGIN = "[a-zA-Z0-9]{3,}";
	private static final String PASSWORD = "[a-zA-Z0-9]{6,}";
	//private static final String GV = "[a-zA-Z0-9А-Яа-я]{1,}";		
	
	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return clazz.equals(RegCommand.class);
	}

	public void validate(Object command, Errors errors) {
		RegCommand regCommand = (RegCommand) command;
		ValidationUtils.rejectIfEmpty(errors, "login", null, "Поле не може бути пустим");
		ValidationUtils.rejectIfEmpty(errors, "password", null, "Поле не може бути пустим");
		ValidationUtils.rejectIfEmpty(errors, "firstName", null, "Поле не може бути пустим");
		ValidationUtils.rejectIfEmpty(errors, "middleName", null, "Поле не може бути пустим");
		ValidationUtils.rejectIfEmpty(errors, "surname", null, "Поле не може бути пустим");
		ValidationUtils.rejectIfEmpty(errors, "vuz", null, "Поле не може бути пустим");
		ValidationUtils.rejectIfEmpty(errors, "group", null, "Поле не може бути пустим");
		if(!regCommand.getLogin().matches(LOGIN)) {
			errors.rejectValue("login", null, "Логін має складатися лише" +
					" з латинських літер і мати довжину більше 2-х символів");
		}
		if(!regCommand.getPassword().matches(PASSWORD)) {
			errors.rejectValue("password", null, "Пароль має складатися" +
					" з латинських літер, цифр і мати довжину більше 5-ти символів");
		}
		if(!regCommand.getFirstName().matches(NAME)) {
			errors.rejectValue("firstName", null, "Імя має починатися" +
					" з великої літери");
		}
		if(!regCommand.getMiddleName().matches(NAME)) {
			errors.rejectValue("middleName", null, "По-батькові має починатися" +
					" з великої літери");
		}
		if(!regCommand.getSurname().matches(NAME)) {
			errors.rejectValue("surname", null, "Прізвище має починатися" +
					" з великої літери");
		}		
	}
}
