package com.project.services;

import java.util.List;

import com.project.entities.User;

public interface AdminService {

	User save(User user);
	User findByEmail(String email);
	List<User> findAll();
	User authenticate(String email, String password, String role);
}
