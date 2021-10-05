package com.project.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.AssignmentDao;
import com.project.dao.DivisionDao;
import com.project.dao.StandardDao;
import com.project.dao.StudentDao;
import com.project.dao.SubjectDao;
import com.project.dao.SubjectTeacherStdDao;
import com.project.dao.TeacherStdDivDao;
import com.project.dao.UserDao;
import com.project.entities.Assignment;
import com.project.entities.Division;
import com.project.entities.Institute;
import com.project.entities.Standard;
import com.project.entities.Student;
import com.project.entities.Subject;
import com.project.entities.SubjectTeacherStd;
import com.project.entities.TeacherStdDiv;
import com.project.entities.User;
import com.project.models.AddTeacherDTO;
import com.project.models.AssignmentDTO;
import com.project.models.Credentials;
import com.project.models.Response;
import com.project.models.StandardDTO;
import com.project.models.StandardSubDTO;
import com.project.models.StdDivDTO;
import com.project.models.StudentDTO;
import com.project.models.SubjectTeacherStdDTO;
import com.project.models.TeacherStdDivDTO;
import com.project.models.UserLoginDTO;
import com.project.services.AssignmentService;
import com.project.services.SaveUserService;
import com.project.services.StandardService;
import com.project.services.SubjectService;
import com.project.services.UserService;
import com.project.services.UtilsService;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class InstituteAdminController {

	
	@Autowired
	private UserDao userDao;
		
	@Autowired
	private StandardService stdService;
	
	@Autowired
	private SubjectService subService;
	
	@Autowired
	private StandardDao stdDao;
	
	@Autowired
	private TeacherStdDivDao teacherstddivdao;
	
	@Autowired
	private SubjectTeacherStdDao subjectteacherstddao;
	
	@Autowired
	private DivisionDao divdao;
	
	@Autowired
	private AssignmentDao assignmentdao;
	
	@Autowired
	private AssignmentService assignmentservice;
	
	@Autowired
	private StudentDao studentdao;
	
	@Autowired
	private SubjectDao subjectdao;
	
	
	@Autowired
	private UtilsService utilservice;
	
	@Autowired
	private SaveUserService saveUser;
	
	//---------------------------Add Teacher Standard Division Subject------------------------------------
	
	
	@RequestMapping("/addteacherstddivsub")
	public ResponseEntity<?> addTeacherDetails(AddTeacherDTO dto){
		 User teacher = saveUser.saveTeacher(dto);
		if(teacher!=null) {			
			return Response.success(teacher);
		}
		return Response.error(null);
	}
	
	
	// ----------------------------------------STANDARD----------------------------------------------------
	
	@RequestMapping("/addstd")
	public ResponseEntity<?> addStandard(StandardDTO dto){	
		Standard standard = StandardDTO.toEntity(dto);
		if(standard!=null) {
			Standard newStandard = stdService.saveStandard(standard);
			return Response.success(newStandard);
		}
		
		return Response.error(null);
	
	}
	
	
	
	@RequestMapping("/deletestd/{id}")
	public ResponseEntity<?> deleteStandard(@PathVariable("id") int id){
		
		
		Standard standard = stdService.findStandard(id);
		if(standard!=null) {
			
			System.out.println("Standard: "+standard);
			 stdDao.deleteById(id);
			
			 String s = "success";
			return Response.success(s);
			}
		return Response.error(null);
	
	}
	
	@RequestMapping("/findallstdbyinstitute/{id}")
	public ResponseEntity<?> findAllStandard(@PathVariable("id") int id){
		
		List<Standard> list = stdService.findByInstituteId(id);
		//List<Standard> stdList = new ArrayList<Standard>();
		Standard std = new Standard();
		if(list!=null) {
			
			System.out.println(list);
			return Response.success(list);
			}	
		return Response.error(null);
	
	}
	
	@RequestMapping("/findstd/{id}")
	public ResponseEntity<?> findStandard(@PathVariable("id") int id){
		
		Standard std = stdService.findStandard(id);
		if(std!=null) {
			System.out.println(std);
			return Response.success(std);
			}	
		return Response.error(null);
	
	}
	
	
	
	
	
	
	
	// ---------------------------------------DIVISION -----------------------------------------------------
	 
	
	
	@RequestMapping("/finddiv/{id}")
	public ResponseEntity<?> findAllStandardbyDiv(@PathVariable("id") int id){
		
		List<Standard> list = stdService.findById(id);
		if(list!=null) {
			System.out.println(list);
			return Response.success(list);
			}	
		return Response.error(null);
	
	}
	
	//Add division to standard
	
	@RequestMapping("/adddiv")
	public ResponseEntity<?> addDivisionByStdandInst(StdDivDTO dto){	
		
		Standard std = stdService.findStandard(dto.getStd_id());
		
//		Standard std = stdService.findStandard(dto.getStd_id(), dto.getInstitute_id());
		  
		Division div = new Division(dto.getDiv_id(), dto.getDiv_name());
		
		std.getDivisionList().add(div);
		
		div.getStdList().add(std);
		
		divdao.save(div);
		Standard standard = stdService.saveStandard(std);
				
		System.out.println(standard);
		if(standard!=null) {
			
			
			return Response.success(standard);
		}
		
		return Response.error(null);
	
	}

	
	@RequestMapping("/deleteDivByStd")
	public ResponseEntity<?> deleteDivByStd(StdDivDTO dto){
		
		Standard standard = stdService.findStandard(dto.getStd_id());
		System.out.println("Standard: "+standard);
		Division division = divdao.findDivision(dto.getDiv_id());
		System.out.println("Division: "+division);
		
		utilservice.deleteDiv(standard, division);

		Standard standard1 = stdService.findStandard(dto.getStd_id());
		if(standard1!=null) {
			
			return Response.success("Successfully deleted");
		}
		
		return Response.error(null);
	
	}
	
	
	
	@RequestMapping("/findsub/{id}")
	public ResponseEntity<?> findSubjectById(@PathVariable("id") int id){

		Standard std = stdDao.findStandard(id);

		if(std!=null) {
			
			return Response.success(std);
		}
		return Response.error(null);
	}
	
	
	
	
	@RequestMapping("/addsub")
	public ResponseEntity<?> addSubjectById(StandardSubDTO dto){
		
		Standard std = stdService.findStandard(dto.getStd_id());
		
//		Standard std = stdService.findStandard(dto.getStd_id(), dto.getInstitute_id());
		
		Subject sub = new Subject(dto.getSub_id(),dto.getSub_name());
		
		std.getSubjectList().add(sub);
		
		sub.getStdList().add(std);
		
		subjectdao.save(sub);
		Standard standard = stdService.saveStandard(std);
		  
		
		
		if(std!=null) {
			
			return Response.success(std);
		}
		return Response.error(null);
	}

	
	
	
	
	
	
	//------------------------------------------TEACHER---------------------------------------------------------
	
	@RequestMapping("/addteacher")
	public ResponseEntity<?> addTeacher(UserLoginDTO dto){
	
	    User user = UserLoginDTO.toEntity(dto);
	    User newUser = userDao.save(user);
		if(newUser!=null) {
			
			return Response.success(newUser);
		}
		return Response.error(null);
	}
	
	
	@RequestMapping("/findAllteacher")
	public ResponseEntity<?> findAllTeacherByInstituteId(Credentials cred,HttpServletRequest req){
	    boolean authenticate = false;
		List<User> AllteacherByInstituteId =   userDao.findAllTeacherByInstituteId(cred.getInstitute_id(),cred.getRole() ); 
	
		if(AllteacherByInstituteId!=null) {
			
			return Response.success(AllteacherByInstituteId);
		}
		
		return Response.error(null);
	}
	
	@RequestMapping("/findallstudents")
	public ResponseEntity<?> findAllStudentsByInstituteId(Credentials cred,HttpServletRequest req){
	    boolean authenticate = false;
		List<User> AllStudentByInstituteId =   userDao.findAllStudentByInstituteId(cred.getInstitute_id(),cred.getRole() ); 
	
		if(AllStudentByInstituteId!=null) {
			
			return Response.success(AllStudentByInstituteId);
		}
		
		return Response.error(null);
	}
	
	@RequestMapping("/findteacher/{id}")
	public ResponseEntity<?> findTeacherById(@PathVariable("id") int id){
		
		//Standard std = stdDao.findStandard(id, 109);
		
		   Optional<TeacherStdDiv> teacher =   teacherstddivdao.findById(id);
		  
		
		
		if(teacher!=null) {
			
			return Response.success(teacher);
		}
		return Response.error(null);
	}
	
	
	//Add Standard and division to teacher
	
	
		@RequestMapping("/addteacherstdiv")
		public ResponseEntity<?> addTeacherStdDiv(TeacherStdDivDTO dto){
			   
			TeacherStdDiv teacherstddiv  =TeacherStdDivDTO.toEntity(dto);
			
        	System.out.println(teacherstddiv);
        	
			if(teacherstddiv!=null) {
				
				teacherstddivdao.save(teacherstddiv);
				
				return Response.success(teacherstddiv);
				
			}
			return Response.error(null);
		}
	
	//Assign subject to teacher 
		
		@RequestMapping("/assignsubteacher")
		
		public ResponseEntity<?> addSubTeacher(SubjectTeacherStdDTO dto){
			
			SubjectTeacherStd subjectstddiv = SubjectTeacherStdDTO.toEntity(dto);
			
			System.out.println(subjectstddiv);
			
                if(subjectstddiv!=null) {
				
                subjectteacherstddao.save(subjectstddiv);
				
				return Response.success(subjectstddiv);
				
			}
			return Response.error(null);
		}
	
		
 
		
		
		
	//---------------------------------------------SUBJECT-------------------------------------------------------------
	
	@RequestMapping("/findsubteacherstd/{id}")
	public ResponseEntity<?> findSubTeacherById(@PathVariable("id") int id){
		
		//Standard std = stdDao.findStandard(id, 109);
		
		   Optional<SubjectTeacherStd> subteacherstd =   subjectteacherstddao.findById(id);
		  
		
		
		if(subteacherstd!=null) {
			
			return Response.success(subteacherstd);
		}
		return Response.error(null);
	}
	
	
	
	// Get Assigment as per User , Std , Div ,Subject
	
	
	@RequestMapping("/getassignment/{id}")
	
	public ResponseEntity<?> findAssignmentById(@PathVariable("id") int id){
		
		
		
		Optional<Assignment> assignment = assignmentdao.findById(id);
		  
		
		
		if(assignment!=null) {
			
			return Response.success(assignment);
		}
		return Response.error(null);
	}


	
	
	
	
	//--------------------------------------------STUDENT--------------------------------------------------------
	
	
		@RequestMapping("/findstudent/{id}")
		public ResponseEntity<?> findStudentById(@PathVariable("id") int id){
			
			//Standard std = stdDao.findStandard(id, 109);
			
			   Optional<Student> student =   studentdao.findById(id);
			  
			
			
			if(student!=null) {
				
				return Response.success(student);
			}
			return Response.error(null);
		}
		
		//add student std div user id
		@RequestMapping("/addstudent")
		public ResponseEntity<?> addStudent(StudentDTO dto){
			   
			Student student  = StudentDTO.toEntity(dto);
			
	    	System.out.println(student);
	    	
			if(student!=null) {
				
				studentdao.save(student);
				
				return Response.success(student);
				
			}
			return Response.error(null);
		}

	
		
		
	
	
	
	
}
