package com.project.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="institute")
public class Institute {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	
    private String email_id;
    private String contact_no;
    private String address;
    private String profilepicture;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="instituteid") // instituteid object name from user class as we are using Bi-Directional Mapping which id FK in user table
	private List<User> userList;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="instituteid")
	private List<Standard> stdList;
	
	public Institute() {
		userList = new ArrayList<User>();
		stdList = new ArrayList<Standard>();
	}
	
	/*public Institute(int id, String name) {
		this.id = id;
		this.name = name;
		this.userList = new ArrayList<User>();
		this.stdList = new ArrayList<Standard>();
	}*/

	
	
	
	

	public Institute(int id, String name, String email_id, String contact_no, String address) {
		this.id = id;
		this.name = name;
		this.email_id = email_id;
		this.contact_no = contact_no;
		this.address = address;
		this.userList = new ArrayList<User>();
		this.stdList = new ArrayList<Standard>();
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	

	public List<Standard> getStdList() {
		return stdList;
	}

	public void setStdList(List<Standard> stdList) {
		this.stdList = stdList;
	}
	
	

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getProfilepicture() {
		return profilepicture;
	}

	public void setProfilepicture(String profilepicture) {
		this.profilepicture = profilepicture;
	}
	
	

	/*@Override
	public String toString() {
		return "Institute [id=" + id + ", name=" + name + ", email_id=" + email_id + ", contact_no=" + contact_no
				+ ", address=" + address + ", userList=" + userList + ", stdList=" + stdList + "]";
	}*/


	
	
	
	
	
	
}
