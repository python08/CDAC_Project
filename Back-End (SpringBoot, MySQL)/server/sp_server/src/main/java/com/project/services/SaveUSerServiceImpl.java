package com.project.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.dao.SubjectTeacherStdDao;
import com.project.dao.TeacherStdDivDao;
import com.project.dao.UserDao;
import com.project.entities.SubjectTeacherStd;
import com.project.entities.TeacherStdDiv;
import com.project.entities.User;
import com.project.models.AddTeacherDTO;
import com.project.models.Response;
import com.project.models.SubjectTeacherStdDTO;
import com.project.models.TeacherStdDivDTO;
import com.project.models.UserLoginDTO;

@Transactional
@Service
public class SaveUSerServiceImpl implements SaveUserService{

	@Autowired
	private PasswordEncoder passworEncoder;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	private TeacherStdDivDao teacherstddivdao;
	
	@Autowired
	private SubjectTeacherStdDao subjectteacherstddao;

	@Override
	public User saveTeacher(AddTeacherDTO user) {
	
	// Finding teacher in User Table
  
	User teacher = userDao.findById(user.getTeacher_id()).get();
	if(teacher!=null) {
		
		// CHILD
		// adding subject of teacher in subjectteacherstd
		SubjectTeacherStdDTO dto2 = new SubjectTeacherStdDTO(user.getSubjectId(), teacher.getId(), user.getStandardId());
		SubjectTeacherStd newSTS = 	SubjectTeacherStdDTO.toEntity(dto2);
		
		// PARENT
		// adding standard and division of teacher in teacherstddiv table
		TeacherStdDivDTO dto = new TeacherStdDivDTO(teacher.getId(), user.getDivisionId(), user.getStandardId());
		TeacherStdDiv teacherstddiv  =TeacherStdDivDTO.toEntity(dto);
		
		teacherstddiv.setSubject(newSTS);
		
		newSTS.setTeacher(teacherstddiv);
		
		teacherstddivdao.save(teacherstddiv);
		
		
		
		if(teacherstddiv!=null){ 
			
			User Teacher = userDao.findById(user.getTeacher_id()).get();
			return Teacher;
			
			
		}
		
	}

		return null;
	}

	@Override
	public User saveStudent(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
