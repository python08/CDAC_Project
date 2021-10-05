package com.project.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.NoticeDao;
import com.project.dao.StudentDetailsDao;
import com.project.entities.Assignment;
import com.project.entities.Notice;
import com.project.entities.Student;
import com.project.entities.StudentDetails;
import com.project.entities.TimeTable;
import com.project.entities.User;
import com.project.models.AssignmentDTO;
import com.project.models.Credentials;
import com.project.models.Response;
import com.project.models.StudentDTO;
import com.project.models.TeacherStdDivDTO;
import com.project.services.AssignmentService;
import com.project.services.StudentService;
import com.project.services.TimeTableService;
import com.project.models.Response;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	private NoticeDao noticedao;

	@Autowired
	StudentDetailsDao studentDetailsDao;
	
	@Autowired
	private AssignmentService assignmentservice;
	
	@Autowired
	private TimeTableService timetableservice;
	
	@RequestMapping("/verify/{email}")	
	public ResponseEntity<?> authenticate(@PathVariable("email") String email) {
	
		User user = studentService.authenticate( email);
		if(user!=null) {
		String result = "verified";
			return Response.success(result);}
		return Response.error(null);
	}
	
	@RequestMapping("/forgetpassword")
	public ResponseEntity<?> forgetPassword(Credentials cred ){
		System.out.println(cred.getEmail() + cred.getPassword());
		int result = studentService.updatePassword(cred.getEmail(), cred.getPassword());
		System.out.println(result);
		if(result == 1)	
			return Response.success(result);
		return Response.error(null);
	}
	
	//_________________find student std div________________________
	
	@RequestMapping("/findStdDiv/{id}")
	public ResponseEntity<?> findStudentStandardDivision(@PathVariable("id") int id) {
		
	     StudentDetails student = studentDetailsDao.findstudentbyuserid(id);
	     if(student!=null) {
	    	 return Response.success(student); 
	     }
	     
	     return Response.error("something went wrong");
	}	
	

	//________________________________ADD ASSIGNMENT________________________________
		
		@RequestMapping("/addstudentassignment")
		public ResponseEntity<?> addStudentAssignment(StudentDTO studentDto) {
			
		      Student student =	StudentDTO.toEntity(studentDto);
		      student =studentService.saveStudent(student ,studentDto.getAssignment_data());
		     
		      return Response.success(student);
		}

	//_____________________________________Delete Assignment_____________
	
			@RequestMapping("/deletestudentassignment/{id}")
			public ResponseEntity<?> deleteStudentAssignmentById(@PathVariable("id") int id){
				
				studentService.deleteAssignmentById(id);
				
				return Response.success("Successfully deleted");
			
			}
			
	@RequestMapping("/findassignmentwrtStdDiv")
	public ResponseEntity<?> findAssignmentwrtUser(AssignmentDTO dto ){
		
		
		  List<Assignment> assignment =   assignmentservice.findAssignmentwrtStdDivSub(dto.getSub_id(), dto.getDiv_id() , dto.getStd_id());

		if(assignment!=null) {
			
			return Response.success(assignment);
		}
		return Response.error(null);
	}

	//________________________get timetable________________
	@RequestMapping("/viewtimetable/{id}")
	public ResponseEntity<?> findTimetableById(@PathVariable("id") int id){
		
		TimeTable timetable = timetableservice.findTimetableByStdId(id);
		System.out.println(timetable);
		if(timetable!=null) {
			
			return Response.success(timetable);
		}
		return Response.error(null);
	}
	
	//_______________________get Notice________________________
	@RequestMapping("/viewnotice/{id}")
	public ResponseEntity<?> findNoticeByStdUserId(@PathVariable("id") int id){
		
		Notice notice = noticedao.findNoticeByStandardId(id);
		if(notice!=null) {
			
			return Response.success(notice);
		}
		return Response.error(null);
	}
	
}
