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

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="student")
public class Student {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
    private int id;
 // private int div_id;
  //private int std_id;
	private int user_id;
	private String assignment_data;
  
//	@JsonIgnore
//	@OneToOne//(targetEntity = User.class , cascade = CascadeType.ALL)
//	private User user;
	
@ManyToOne
@JoinColumn(name="std_id")
private Standard standard;


@ManyToOne
@JoinColumn(name="div_id")
private Division division;
  

@ManyToOne
@JoinColumn(name="assignment_id")
private Assignment assignment;

@ManyToOne
@JoinColumn(name="stddetails_id")
private StudentDetails studentdetails;

	
	
  public Student() {
	//this.user = new User();
	this.assignment = new Assignment();
	
  }

public Student(int id) {
	this.id = id;
	//this.user = new User();
	this.assignment = new Assignment();
}




public Assignment getAssignment() {
	return assignment;
}

public void setAssignment(Assignment assignment) {
	this.assignment = assignment;
}

public Division getDivision() {
	return division;
}

public void setDivision(Division division) {
	this.division = division;
}

public Standard getStandard() {
	return standard;
}

public void setStandard(Standard standard) {
	this.standard = standard;
}



public int getId() {
	return id;
}
/*
public Division getDivision() {
	return division;
}

public void setDivision(Division division) {
	this.division = division;
}*/

public void setId(int id) {
	this.id = id;
}

//public User getUser() {
//	return user;
//}
//
//public void setUser(User user) {
//	this.user = user;
//}



public String getAssignment_data() {
	return assignment_data;
}

public int getUser_id() {
	return user_id;
}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}

public void setAssignment_data(String assignment_data) {
	this.assignment_data = assignment_data;
}





public StudentDetails getStudentdetails() {
	return studentdetails;
}

public void setStudentdetails(StudentDetails studentdetails) {
	this.studentdetails = studentdetails;
}

@Override
public String toString() {
	return "Student [id=" + id + ", assignment_data=" + assignment_data + ", standard=" + standard + ", division="
			+ division + ", assignment=" + assignment + ", studentdetails=" + studentdetails + "]";
}



}
