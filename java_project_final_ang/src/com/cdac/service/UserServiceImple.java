package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.UserDao;
import com.cdac.dto.User;

@Service
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public boolean findUser(User user) {
		return userDao.checkUser(user);
	}
	@Override
	public boolean updatepass(User user) {
		return userDao.updateuser(user);
	}

	@Override
	public boolean verifymail(User user) {
		// TODO Auto-generated method stub
		return userDao.verify_mail(user);
	}

	@Override
	public void setpass(User user) {
		// TODO Auto-generated method stub
		userDao.resetpass(user);
	}

		
}
