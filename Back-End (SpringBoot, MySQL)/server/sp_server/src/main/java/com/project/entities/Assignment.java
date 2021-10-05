package com.project.entities;

import java.io.Serializable;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="assignment")
public class Assignment  {
    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
    private int id;
//	private int user_id;
//	private int sub_id;
//	private int div_id;
	private String deadline;
	private String assignment;
//	private int std_id;
	private String assignment_title;
	
	
	@JsonIgnore 
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name="sub_id")
	private Subject subject;
	
	 @JsonIgnore
	@ManyToOne
	@JoinColumn(name="std_id")
	private Standard standard;
	
	//(cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@ManyToOne //(cascade = { CascadeType.ALL})
	@JoinColumn(name="div_id")
	private Division division;
	
	/*@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;*/
	
	
	@JsonIgnore	
	@OneToMany(mappedBy="assignment")
	private List<Student> studentList;
	
	
	public Assignment() {
		this.user= new User();
		this.subject= new Subject();
		this.standard=new Standard();
		this.division=new Division();
		this.studentList = new ArrayList<Student>();
	}


	public Assignment(int id, String deadline, String assignment) {
			
		this.id = id;
		this.deadline = deadline;
		this.assignment = assignment;
		this.user= new User();
		this.subject= new Subject();
		this.standard=new Standard();
		this.division=new Division();
		this.studentList = new ArrayList<Student>();
	}

	
	

	public List<Student> getStudentList() {
		return studentList;
	}


	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}


	public Standard getStandard() {
		return standard;
	}


	public void setStandard(Standard standard) {
		this.standard = standard;
	}


/*	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}*/


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDeadline() {
		return deadline;
	}


	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}


	public String getAssignment() {
		return assignment;
	}


	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Subject getSubject() {
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}



	public Division getDivision() {
		return division;
	}


	public void setDivision(Division division) {
		this.division = division;
	}

	

	public String getAssignment_title() {
		return assignment_title;
	}


	public void setAssignment_title(String assignment_title) {
		this.assignment_title = assignment_title;
	}


	@Override
	public String toString() {
		return "Assignment [id=" + id + ", deadline=" + deadline + ", assignment=" + assignment + ", assignment_title="
				+ assignment_title + ", user=" + user + ", subject=" + subject + ", standard=" + standard
				+ ", division=" + division + ", studentList=" + studentList + "]";
	}


	 
	

	}