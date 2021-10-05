package com.project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.SubjectTeacherStd;
import com.project.entities.TeacherStdDiv;
import com.project.entities.User;
import com.project.models.Credentials;

import com.project.models.Response;
import com.project.models.UserLoginDTO;

import com.project.services.UserService;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/authenticate")
	public ResponseEntity<?> authenticate(Credentials cred) {
		User user = userService.authenticate(cred.getEmail(), cred.getPassword());
		if(user!=null) {
			
		
			System.out.println(user);
			
			return Response.success(user);
			}
		return Response.error(null);
	}
	
	@RequestMapping("/finduser/{id}")
	public User findUser(@PathVariable("id") int id) {
		User user = userService.findById(id);
		
		System.out.println(user);
		return user;
	}
	
	
	
		
}
