package com.mycompany.school.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mycompany.school.model.Student;

@Component
public class StudentFormValidator implements Validator{

	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Student student = (Student) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.userForm.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.userForm.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.userForm.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "NotEmpty.userForm.emailAddress");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "NotEmpty.userForm.dateOfBirth");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.userForm.confirmPassword");

		if(!emailValidator.valid(student.getEmailAddress())){
			errors.rejectValue("emailAddress", "Pattern.userForm.emailAddress");
		}
		
		if (!student.getPassword().equals(student.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
		}
		
		if (student.getPassword().length() > 8) {
			errors.rejectValue("password", "Valid.userForm.password");
		}

		if (student.getUserName().length() > 20) {
			errors.rejectValue("userName", "Valid.userForm.userName");
		}
	}
}
