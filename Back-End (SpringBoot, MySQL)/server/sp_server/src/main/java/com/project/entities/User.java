package com.project.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private String mobile;
	private String role;
	private String profilepicture;
	
	@ManyToOne
	@JoinColumn(name="institute_id")      // institute_id is FK column in "user table"
	private Institute instituteid;        //private int role_id; didnt used this as we are making bi directional one to many and many to one mapping

	          
	
	@OneToMany(mappedBy="user") // standard object name from user class as we are using Bi-Directional Mapping which id FK in user table
	private List<TeacherStdDiv> teacherStdDivList;
	
	
	
    @OneToMany(mappedBy="user")
    private List<SubjectTeacherStd> subjectTeacherStdList;
	
	
	@OneToMany(mappedBy="user") 
	private List<Assignment> assignmentList;
	
	@OneToOne(mappedBy="user")
	private TimeTable timetable;
 
	@OneToOne(mappedBy="user")
    private Notice notice;

	
	 /* @OneToOne
	  @PrimaryKeyJoinColumn
	  private Student student; 
*/   
	@JsonIgnore
	@OneToOne(targetEntity = StudentDetails.class , mappedBy="user")
	private StudentDetails studentdetails;
	
	
	
	public User() {
		this.instituteid = new Institute();
		this.teacherStdDivList = new ArrayList<TeacherStdDiv>();
		this.subjectTeacherStdList = new ArrayList<SubjectTeacherStd>(); 
		this.assignmentList=new ArrayList<Assignment>();
		//this.student = new Student();
	}
	

	public User( String firstname, String lastname,String username, String password, String email, String mobile,String role) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.role = role;
		this.instituteid = new Institute();
		this.teacherStdDivList = new ArrayList<TeacherStdDiv>();
		this.subjectTeacherStdList = new ArrayList<SubjectTeacherStd>(); 
		this.assignmentList=new ArrayList<Assignment>();
	  //  this.student = new Student();
		
	}

	

	public StudentDetails getStudentdetails() {
		return studentdetails;
	}


	public void setStudentdetails(StudentDetails studentdetails) {
		this.studentdetails = studentdetails;
	}


	public TimeTable getTimetable() {
		return timetable;
	}

	public void setTimetable(TimeTable timetable) {
		this.timetable = timetable;
	}

	public List<Assignment> getAssignmentList() {
		return assignmentList;
	}

	public void setAssignmentList(List<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}

	public List<SubjectTeacherStd> getSubjectTeacherStdList() {  //getter and setter for subjectTeacherStdList
		return subjectTeacherStdList;
	}

	public void setSubjectTeacherStdList(List<SubjectTeacherStd> subjectTeacherStdList) {
		this.subjectTeacherStdList = subjectTeacherStdList;
	}

	

	public String getProfilepicture() {
		return profilepicture;
	}

	public void setProfilepicture(String profilepicture) {
		this.profilepicture = profilepicture;
	}

	public List<TeacherStdDiv> getTeacherStdDivList() {
		return teacherStdDivList;
	}

	public void setTeacherStdDivList(List<TeacherStdDiv> teacherStdDivList) {
		this.teacherStdDivList = teacherStdDivList;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Institute getInstituteid() {
		return instituteid;
	}

	public void setInstituteid(Institute instituteid) {
		this.instituteid = instituteid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", mobile=" + mobile + ", role=" + role
				+ ", profilepicture=" + profilepicture + ", instituteid=" + instituteid + ", timetable=" + timetable
				+ ", notice=" + notice + "]";
	}

	


	
}


