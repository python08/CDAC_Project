package com.project.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="standard")
public class Standard {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name="std_name")
	private String standardName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="institute_id")
	private Institute instituteid;
	
	@ManyToMany(cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinTable(
			   name="stddivinst",     // auxiliary table name
			   joinColumns = { @JoinColumn(name = "std_id") },     // FK column name from auxiliary table wrt  to standard table       
			   inverseJoinColumns = { @JoinColumn(name = "div_id") } // FK column name from auxiliary table wrt  to division table
			  )
	private List<Division> divisionList;
	
	
	@ManyToMany//(cascade=CascadeType.ALL)
	@JoinTable(
			 name="stdsubinst",
			 joinColumns = { @JoinColumn(name = "std_id") } ,
			 inverseJoinColumns = { @JoinColumn(name = "sub_id")}
			)
	private List<Subject> subjectList;
	
	@JsonIgnore
	@OneToMany(mappedBy="standard") // standard object name from user class as we are using Bi-Directional Mapping which id FK in user table
	private List<TeacherStdDiv> teacherStdDivList;
	
	
	 @JsonIgnore
	 @OneToMany(mappedBy="standard")
	 private List<SubjectTeacherStd> subjectTeacherStdList;
	 

		
	@OneToMany(mappedBy="standard") 
	private List<Assignment> assignmentList;
	
	@JsonIgnore	
	@OneToMany(mappedBy="standard")
	private List<Student> studentList;

 
	@OneToOne(mappedBy="std")
	private TimeTable timetable;
       
   
       
    
       @OneToOne(mappedBy="standard")
       private Notice notice;
   
public void removeDivision(Division division) {
    this.divisionList.remove(division);
    division.getStdList().remove(this);
}







	public List<Assignment> getAssignmentList() {
			return assignmentList;
		}


		public List<Student> getStudentList() {
		return studentList;
	}


	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}


		public void setAssignmentList(List<Assignment> assignmentList) {
			this.assignmentList = assignmentList;
		}


	public List<SubjectTeacherStd> getSubjectTeacherStdList() {  // getter setter for subjectTeacherStdList (OneToMany)
		return subjectTeacherStdList;
	}


	public void setSubjectTeacherStdList(List<SubjectTeacherStd> subjectTeacherStdList) {
		this.subjectTeacherStdList = subjectTeacherStdList;
	}


	public List<Subject> getSubjectList() {    //getter setter for subjectList (ManyToMany)
		return subjectList;
	}


	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
		//this.student = new Student();
	}

	
	

	public TimeTable getTimetable() {
		return timetable;
	}

	public void setTimetable(TimeTable timetable) {
		this.timetable = timetable;
	}





	public Standard() {
		this.instituteid = new Institute();
		this.divisionList = new ArrayList<Division>();
		this.subjectList = new ArrayList<Subject>();
		this.teacherStdDivList = new ArrayList<TeacherStdDiv>();
		this.subjectTeacherStdList = new ArrayList<SubjectTeacherStd>(); 
		this.assignmentList=new ArrayList<Assignment>();
	    this.studentList = new ArrayList<Student>();
	    //this.timetable = new TimeTable();
	    //this.notice=new Notice();
		
	}
	
	
	public Standard(int id,String standardName) {
		this.id=id;
		this.standardName = standardName;
		this.instituteid = new Institute();
		this.divisionList = new ArrayList<Division>();
		this.subjectList = new ArrayList<Subject>();
		this.teacherStdDivList = new ArrayList<TeacherStdDiv>();
		this.subjectTeacherStdList = new ArrayList<SubjectTeacherStd>();
		this.assignmentList=new ArrayList<Assignment>();
	//	this.timetable = new TimeTable();
	//	this.notice=new Notice();
	}
	
	public Standard(int id,String standardName,Institute institute) {
		this.id=id;
		this.standardName = standardName;
		this.instituteid = new Institute();
		this.divisionList = new ArrayList<Division>();
		this.subjectList = new ArrayList<Subject>();
		this.teacherStdDivList = new ArrayList<TeacherStdDiv>();
		this.subjectTeacherStdList = new ArrayList<SubjectTeacherStd>();
		this.assignmentList=new ArrayList<Assignment>();
	//	this.timetable = new TimeTable();
	}

	

	public String getStandardName() {
		return standardName;
	}


	public void setStandardName(String standardName) {
		this.standardName = standardName;
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


	


	public List<Division> getDivisionList() {
		return divisionList;
	}


	public void setDivisionList(List<Division> divisionList) {
		this.divisionList = divisionList;
	}
	
	
	


	public List<TeacherStdDiv> getTeacherStdDivList() {
		return teacherStdDivList;
	}


	public void setTeacherStdDivList(List<TeacherStdDiv> teacherStdDivList) {
		this.teacherStdDivList = teacherStdDivList;
	}
	
	
	
	



	public Notice getNotice() {
		return notice;
	}


	public void setNotice(Notice notice) {
		this.notice = notice;
	}





	@Override
	public String toString() {
		return "Standard [id=" + id + ", standardName=" + standardName + ", instituteid=" + instituteid + ", timetable="
				+ timetable + ", notice=" + notice + "]";
	}




	
	
}
