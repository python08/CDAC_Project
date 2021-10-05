package com.project.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Institute;
import com.project.entities.Standard;
import com.project.entities.User;

import com.project.models.Credentials;
import com.project.models.InstituteDTO;
import com.project.models.Response;
import com.project.models.StandardDTO;
import com.project.services.AdminService;
import com.project.services.InstituteService;
import com.project.services.StandardService;
import com.project.services.UserService;


@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class AdminController {

	
	@Autowired
	private InstituteService instituteService;

	
	@RequestMapping("/addinstitute")
	public ResponseEntity<?> addInstitute(InstituteDTO dto){
		Institute ist = InstituteDTO.toEntity(dto);	
		if(ist!=null) {
			Institute newInstitute = instituteService.saveName(ist);
			System.out.println(newInstitute);
			return Response.success(newInstitute);
			}
		return Response.error(null);
	
	}
	
	@RequestMapping("/deleteinstitute/{id}")
	public ResponseEntity<?> deleteInstitute(@PathVariable("id") int id){
		if(id!=0) {
			 instituteService.deleteInstitute(id);
			 String s = "success";
			return Response.success(s);
			}
		return Response.error(null);
	
	}
	
	@RequestMapping("/findinstitute")
	public ResponseEntity<?> findAllInstitute(){	
		List<Institute> list = instituteService.findAllInstitute();
		if(list!=null) {
			return Response.success(list);
			}	
		return Response.error(null);
	
	}
	
	
	
	
}
