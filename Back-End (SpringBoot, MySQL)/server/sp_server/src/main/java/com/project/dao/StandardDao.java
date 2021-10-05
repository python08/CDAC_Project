package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entities.Division;
import com.project.entities.Standard;



public interface StandardDao extends JpaRepository<Standard, Integer>{

	@Query("select s from Standard s where s.instituteid.id=?1 ")
	List<Standard> findStandardbyinstituteid(int id);
	
	
	List<Standard> findById(int id);
	
	@Query("select s from Standard s where s.id=?1")
	Standard findStandard(int stdid);
	
/*
	@Query("select s from Standard s where s.id=?1 and s.instituteid.id=?2")
	Standard findStandard(int stdid,int instId);
*/

	
	
}
