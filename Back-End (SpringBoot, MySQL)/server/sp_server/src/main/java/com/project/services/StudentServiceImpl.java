package com.project.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.dao.StudentDao;
import com.project.dao.UserDao;
import com.project.entities.Student;
import com.project.entities.User;
import com.project.utils.StorageService;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	UserDao userdao;
	
	@Autowired
	private PasswordEncoder passworEncoder;
	
	@Autowired
	private StorageService storageService;
	
	@Autowired
	private StudentDao studentdao;

	@Override
	public User findByEmail(String email) {
		return userdao.findByEmail(email);
	}

	@Override
	public User authenticate(String email) {
		User user = findByEmail(email);
		if(user !=null )
			return user;
		return null;
	}

	@Override
	public int updatePassword(String email, String password) {
		String encPassword =	passworEncoder.encode(password);
		 int result = userdao.updatePassword(email, encPassword);
		return result;
	}

	@Override
	public Student saveStudent(Student student, MultipartFile assignment_data) {
		
		String filename = storageService.store(assignment_data);
		System.out.println(filename);
		student.setAssignment_data(filename);
		
		return studentdao.save(student);
	}

	@Override
	public void deleteAssignmentById(Integer id) {
		
		studentdao.deleteById(id);
	}

	
	
	
}
