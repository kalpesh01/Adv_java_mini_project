package com.cdac.cntr;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.cdac.dto.User;
import com.cdac.service.UserService;
import com.cdac.valid.ForgotPValidator;
import com.cdac.valid.RegValidator;
import com.cdac.valid.UserValidator;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private RegValidator regValidator;
	
	@Autowired
	private ForgotPValidator forgot;
	
	
	
	@RequestMapping(value = "/prep_reg_form.htm",method = RequestMethod.GET)
	public String prepRegForm(ModelMap map) {
		map.put("user", new User());
		return "reg_form";
	}
	
	@RequestMapping(value = "/reg.htm",method = RequestMethod.POST)
	public String register(@ModelAttribute User user,BindingResult result,ModelMap map) {
		
		regValidator.validate(user, result);
		if(result.hasErrors()) {
			return "reg_form";
		}
		
		userService.addUser(user);
		return "index";
	}
	
	@RequestMapping(value = "/prep_log_form.htm",method = RequestMethod.GET)
	public String prepLogForm(ModelMap map) {
		map.put("user", new User());
		return "login_form";
	}
	
	@RequestMapping(value = "/login.htm",method = RequestMethod.POST)
	public String login(@ModelAttribute User user,BindingResult result,ModelMap map,HttpSession session,SessionStatus status) {
		if(!status.isComplete() ) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "login_form";
		}
		
		boolean b = userService.findUser(user);
		if(b) {
			session.setAttribute("user", user); 
			return "home";
		}else {
			map.put("user", new User());
			return "login_form";
		} } else {
			session.setAttribute("user", new User()); 
			map.put("user", user);
			return "login_form";
		}
	}
		
	
	@RequestMapping(value = "/logout.htm",method = RequestMethod.GET)
	public String logout(@ModelAttribute User user,HttpSession session,ModelMap map,SessionStatus status,WebRequest request) {
		 status.setComplete();
		 request.removeAttribute("user", WebRequest.SCOPE_SESSION);
		return "index";
	}
	
//	@RequestMapping(value = "/prep_forgetpass_form.htm",method = RequestMethod.GET)
//	public String forgetForm(ModelMap map) {
//		map.put("user", new User());
//		return "forgot_pass";
//	}
//	
//	@RequestMapping(value = "/forgetpass.htm",method = RequestMethod.POST)
//	public String forgetpass(@ModelAttribute User user,BindingResult result,ModelMap map,HttpSession session,SessionStatus status) {
//		
//		forgot.validate(user, result);
//		
//		if(result.hasErrors()) {
//			return "forgot_pass";
//		}
//		
//		userService.updatepass(user);
//		map.put("user", new User());
//		return "login_form";
//		
//		boolean b = userService.updatepass(user);
//		if(b) {
//			map.put("user", new User());
//			return "login_form";
//		}else {
//			map.put("user", new User());
//			return "forgot_pass";
//		} 
//}
	
	
	
	@RequestMapping(value = "/prep_forget_pass1.htm",method = RequestMethod.GET)
	public String forget_pass_Form1(ModelMap map) {
		map.put("user", new User());
		return "forget_pass1";
	}
	
	@RequestMapping(value = "/forget_pass_email.htm",method = RequestMethod.POST)
	public String forgetpass1(@ModelAttribute User user,BindingResult result,ModelMap map,HttpSession session,SessionStatus status) {
		
//		if(result.hasErrors()) {
//			return "login_form";
//		}
		boolean b = userService.verifymail(user);
		if(b) {
			map.put("user", user);
			return "forget_pass2";			//password
		}else {
			map.put("user", new User());
			return "forget_pass1";			//emailid
		} 
	}
	
	@RequestMapping(value = "/prep_forget_pass2.htm",method = RequestMethod.GET)
	public String forget_pass_Form2(ModelMap map,@ModelAttribute User user) {
		map.put("user", user);
		return "forget_pass2";
	}
	
	
	@RequestMapping(value = "/forget_pass_pass.htm",method = RequestMethod.POST)
	public String forgetpass2(@ModelAttribute User user,BindingResult result,ModelMap map,HttpSession session,SessionStatus status) {
		
//		if(result.hasErrors()) {
//			return "login_form";
//		}
		
		userService.setpass(user);
		
		return "index";
		
}
}
