package com.cdac.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

import com.cdac.dto.User;

@Service
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
			
		User user = (User) target;
		
		if(!user.getEmailId().isEmpty())
		{
			String mail=user.getEmailId();
			
			String emailRegex="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
			Pattern emailPat=Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
			Matcher matcher=emailPat.matcher(mail);
			if(!matcher.find())
			{
				System.out.println("=======================================");
				errors.rejectValue("emailId", "unmKey", "email is invalid");
			}
		}else {
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			errors.rejectValue("emailId", "unm", "userName is required");
		}
		
		

		
		if(!user.getUserPass().isEmpty())
		{
			String pass=user.getUserPass();
			
			String passRegex="[a-zA-Z0-9]*";
			Pattern emailPat=Pattern.compile(passRegex);
			Matcher matcher=emailPat.matcher(pass);
			if(!matcher.matches())
			{
				System.out.println("=======================================");
				errors.rejectValue("userPass", "passKey", "password is invalid");
			}
		}else {
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			errors.rejectValue("userPass", "passKey1", "password is required");
		}
		
		
	}
		
		
	}
	

