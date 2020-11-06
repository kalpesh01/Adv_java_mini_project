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
public class RegValidator implements Validator{

	@Autowired
	UserDao userDao;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User) target;
		
		String fname=user.getFirstName();
		String lname=user.getLastName();
		if(fname.isEmpty() && lname.isEmpty()) {
			errors.rejectValue("firstName", "fnameKey", "insert First Name");
			errors.rejectValue("lastName", "lnameKey", "insert Last Name");
		}
		
		//emailId
		
		if(userDao.checkEmail(user))
		{
			errors.rejectValue("emailId", "emailKey", "email already exist");
		}
		else if(!user.getEmailId().isEmpty())
		{
			
			
			String mail=user.getEmailId();
			
			String emailRegex="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
			Pattern emailPat=Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
			Matcher matcher=emailPat.matcher(mail);
			if(!matcher.find())
			{
				System.out.println("=======================================");
				errors.rejectValue("emailId", "emailKey", "email is invalid");
			}
		}else {
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			errors.rejectValue("emailId", "emailKey", "EmailId is required");
		}
		
		
		
		
		//password
		if(!user.getUserPass().isEmpty())
		{
			String pass=user.getUserPass();
			
			String passRegex="[a-zA-Z0-9]*";
			Pattern passPat=Pattern.compile(passRegex);
			Matcher matcher=passPat.matcher(pass);
			if(!matcher.matches())
			{
				System.out.println("=======================================");
				errors.rejectValue("userPass", "passKey", "password is invalid");
			}
		}else {
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			errors.rejectValue("userPass", "passKey", "password is required");
		}
		
		
		
		//contact no
				if(!user.getContactNo().isEmpty())
				{
					String pass=user.getContactNo();
					
					String passRegex="^[0-9]{10}$";
					Pattern passPat=Pattern.compile(passRegex);
					Matcher matcher=passPat.matcher(pass);
					if(!matcher.matches())
					{
						System.out.println("=======================================");
						errors.rejectValue("contactNo", "contactKey", "Contact No is invalid");
					}
				}else {
					
					System.out.println("+++++++++++++++++++++++++++++++++++++++++");
					errors.rejectValue("contactNo", "contactKey", "Contact No is required");
				}
		
	}
		
}





