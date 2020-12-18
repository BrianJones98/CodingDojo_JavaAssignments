package com.brian.beltreviewer.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.brian.beltreviewer.models.User;

@Component
public class UserValidator implements Validator {

	//Determines which model to use
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	//Checks if password field matches password confirmation field
	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
	}
}
