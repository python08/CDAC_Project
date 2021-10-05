package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.dao.UserDao;
import com.project.entities.User;
import com.project.utils.StorageService;

@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userdao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private StorageService storageService;

	
	@Override
	public User findById(int id) {
		Optional<User> cust = userdao.findById(id);
		return cust.orElse(null);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userdao.findByEmail(email);
	}

	

	@Override
	public User authenticate(String email, String password) {
		User user = findByEmail(email);
		if(user !=null && passwordEncoder.matches(password, user.getPassword()))
			return user;
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllTeacherByInstituteId(int id, String role) {
		
		return userdao.findAllTeacherByInstituteId(id, role);
	}

	@Override
	public User addTeacher(User user) {
		// TODO Auto-generated method stub
		return userdao.save(user);
	}

	@Override
	public User saveUser(User user, MultipartFile profilepicture) {
		
		String fileName = storageService.store(profilepicture); //profilepic store in filename for convert
		user.setProfilepicture(fileName);
		return userdao.save(user) ;
	}
	
	@Override
	public int updateProfile(String firstname, String lastname, String username, String password, String mobile,
			MultipartFile profilepicture, int id) {
		
		String filename = storageService.store(profilepicture);
		String encPassword = passwordEncoder.encode(password);
		
		return userdao.updateProfile(firstname, lastname, username, encPassword, mobile, filename, id);
		
		
	}



	

}
