package com.xixi.service;

import com.xixi.model.User;
import com.xixi.service.impl.BaseServiceImpl;

public interface UserService extends BaseService<User> {
	public User login(User user);
}
