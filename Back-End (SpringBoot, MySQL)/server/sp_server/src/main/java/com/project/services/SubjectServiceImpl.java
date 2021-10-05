package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectService subService;
	
	@Override
	public void findByid(int id) {
		
		subService.findByid(id);
		
	}

}
