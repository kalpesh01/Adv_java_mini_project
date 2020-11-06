package com.cdac.service;

import com.cdac.dto.User;

public interface UserService {
	void addUser(User user);
	boolean findUser(User user);
	boolean updatepass(User user);
	boolean verifymail(User user);
	void setpass(User user);
	
}
