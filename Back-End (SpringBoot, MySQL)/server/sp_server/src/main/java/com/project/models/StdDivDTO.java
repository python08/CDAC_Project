package com.project.models;

import org.springframework.beans.BeanUtils;

import com.project.entities.Division;
import com.project.entities.Institute;
import com.project.entities.Standard;

public class StdDivDTO {

	private int std_id;
	private String std_name;
	private int div_id;
	private String div_name;
	private int institute_id; 
	
	public StdDivDTO() {
		
	}
		

	public StdDivDTO(int std_id,String std_name, int div_id, String div_name) {
		this.std_id = std_id;
		this.std_name=std_name;
		this.div_id = div_id;
		this.div_name = div_name;
		
		
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


	public String getDiv_name() {
		return div_name;
	}

	public void setDiv_name(String div_name) {
		this.div_name = div_name;
	}



	public int getInstitute_id() {
		return institute_id;
	}


	public void setInstitute_id(int institute_id) {
		this.institute_id = institute_id;
	}


	public String getStd_name() {
		return std_name;
	}


	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}




	
}
