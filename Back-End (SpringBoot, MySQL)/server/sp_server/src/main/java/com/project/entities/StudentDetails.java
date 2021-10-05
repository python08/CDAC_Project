package com.project.entities;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="studentdetails")
public class StudentDetails {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	private int std_id;
	private int div_id;
	
	
	@OneToOne//(targetEntity = User.class , cascade = CascadeType.ALL)
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy="studentdetails")
	private List<Student> studentList;
	
	public StudentDetails() {
		// TODO Auto-generated constructor stub
	}

	public StudentDetails(int id, int std_id, int div_id, List<Student> studentList) {
		this.id = id;
		this.std_id = std_id;
		this.div_id = div_id;
		this.user = new User();
		this.studentList = studentList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStd_id() {
		return std_id;
	}

	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}

	public int getDiv_id() {
		return div_id;
	}

	public void setDiv_id(int div_id) {
		this.div_id = div_id;
	}

	/*
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
*/
	
	public List<Student> getStudentList() {
		return studentList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", std_id=" + std_id + ", div_id=" + div_id + ", user=" + user
				+ ", studentList=" + studentList + "]";
	}

	

	
	
}
