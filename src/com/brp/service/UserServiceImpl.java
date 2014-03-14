package com.brp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brp.bean.UserBean;
import com.brp.dao.UserDAO;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao;

	@Override
	@Transactional
	public UserBean signInUser(UserBean userBeanObj) {
		// TODO Auto-generated method stub
		return userDao.signInUser(userBeanObj);
	}
	
}
