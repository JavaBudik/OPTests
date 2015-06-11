package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;


public class RegValidator implements Validator {
	
	private static final String NAME = "^[A-Z�-߲��][a-zA-Z�-��-߲�����-]{1,}";
	private static final String LOGIN = "[a-zA-Z0-9]{3,}";
	private static final String PASSWORD = "[a-zA-Z0-9]{6,}";
	//private static final String GV = "[a-zA-Z0-9�-��-�]{1,}";		
	
	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return clazz.equals(RegCommand.class);
	}

	public void validate(Object command, Errors errors) {
		RegCommand regCommand = (RegCommand) command;
		ValidationUtils.rejectIfEmpty(errors, "login", null, "���� �� ���� ���� ������");
		ValidationUtils.rejectIfEmpty(errors, "password", null, "���� �� ���� ���� ������");
		ValidationUtils.rejectIfEmpty(errors, "firstName", null, "���� �� ���� ���� ������");
		ValidationUtils.rejectIfEmpty(errors, "middleName", null, "���� �� ���� ���� ������");
		ValidationUtils.rejectIfEmpty(errors, "surname", null, "���� �� ���� ���� ������");
		ValidationUtils.rejectIfEmpty(errors, "vuz", null, "���� �� ���� ���� ������");
		ValidationUtils.rejectIfEmpty(errors, "group", null, "���� �� ���� ���� ������");
		if(!regCommand.getLogin().matches(LOGIN)) {
			errors.rejectValue("login", null, "���� �� ���������� ����" +
					" � ���������� ���� � ���� ������� ����� 2-� �������");
		}
		if(!regCommand.getPassword().matches(PASSWORD)) {
			errors.rejectValue("password", null, "������ �� ����������" +
					" � ���������� ����, ���� � ���� ������� ����� 5-�� �������");
		}
		if(!regCommand.getFirstName().matches(NAME)) {
			errors.rejectValue("firstName", null, "��� �� ����������" +
					" � ������ �����");
		}
		if(!regCommand.getMiddleName().matches(NAME)) {
			errors.rejectValue("middleName", null, "��-������� �� ����������" +
					" � ������ �����");
		}
		if(!regCommand.getSurname().matches(NAME)) {
			errors.rejectValue("surname", null, "������� �� ����������" +
					" � ������ �����");
		}		
	}
}
