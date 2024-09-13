package com.java.spring.service;

import com.java.spring.entity.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
