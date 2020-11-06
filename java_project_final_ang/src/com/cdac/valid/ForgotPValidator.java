package com.cdac.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

import com.cdac.dao.UserDao;
import com.cdac.dto.User;

@Service
public class ForgotPValidator implements Validator {

	
	@Autowired
	UserDao userDao;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
			
		User user = (User) target;
		
		
		

		if(!userDao.checkEmail(user))
		{
			errors.rejectValue("emailId", "emailKey", "Enter The Registered Email ");
		}
//		else if(!user.getEmailId().isEmpty())
//		{
//			
//			
//			String mail=user.getEmailId();
//			
//			String emailRegex="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
//			Pattern emailPat=Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
//			Matcher matcher=emailPat.matcher(mail);
//			if(!matcher.find())
//			{
//				System.out.println("=======================================");
//				errors.rejectValue("emailId", "emailKey", "email is invalid");
//			}
//		}
//		else {
//			
//			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
//			errors.rejectValue("emailId", "emailKey", "EmailId is required");
//		}
		
		
		
	}
		
		
	}
	

