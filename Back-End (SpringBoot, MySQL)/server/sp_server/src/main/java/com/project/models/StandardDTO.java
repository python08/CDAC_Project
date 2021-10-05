package com.project.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.project.entities.Institute;
import com.project.entities.Standard;

public class StandardDTO {

	private int id;
	private String standardName;
	private int institute_id;
	private String institutename;
	
	public StandardDTO() {
		this.id = 0;
		
	}
	
	public StandardDTO(String standardName, int institute_id, String institutename) {
		this.id = 0;
		this.standardName = standardName;
		this.institute_id = institute_id;
		this.institutename = institutename;
	}
	
	
	public String getInstitutename() {
		return institutename;
	}

	public void setInstitutename(String institutename) {
		this.institutename = institutename;
	}

	public String getStandardName() {
		return standardName;
	}
	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}
	public int getInstitute_id() {
		return institute_id;
	}
	public void setInstitute_id(int institute_id) {
		this.institute_id = institute_id;
	}

	@Override
	public String toString() {
		return "StandardDTO [id=" + id + ", standardName=" + standardName + ", institute_id=" + institute_id + "]";
	}
	
	public static Standard toEntity(StandardDTO dto){
		Standard std = new Standard();
		BeanUtils.copyProperties(dto, std);
		Institute ist = new Institute();
		ist.setId(dto.getInstitute_id());
		std.setInstituteid(ist);
		return std;
	}
	

	
	
}
