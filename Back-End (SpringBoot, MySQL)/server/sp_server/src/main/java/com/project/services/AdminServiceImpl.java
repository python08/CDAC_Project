package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.InstituteDao;
import com.project.dao.UserDao;
import com.project.entities.User;
@Transactional
@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	UserDao userdao;
	
	@Autowired
	InstituteDao instituteDao;
	
	@Autowired
	private PasswordEncoder passworEncoder;
	
	@Override
	public User save(User user) {
		String encPassword =	passworEncoder.encode(user.getPassword());
		user.setPassword(encPassword);
		return userdao.save(user);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User authenticate(String email, String password, String role) {
//		int r = roleDao.findByRolename(role); 
//		User user = findByEmail(email);
//		if(user !=null && passworEncoder.matches(password, user.getPassword()) && ()user.getRoleid() == r)
//			return user;
		return null;
	}

}
