package com.xixi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xixi.model.User;
import com.xixi.service.UserService;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String hql="from User u where u.login=:login and u.pass =:pass";
		return (User)getSession()
				.createQuery(hql)
				.setString("login", user.getLogin())
				.setString("pass",user.getPass())
				.uniqueResult();
	}

}
