package com.project.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.dao.InstituteDao;
import com.project.entities.Institute;
import com.project.utils.StorageService;


@Service
public class InstituteServiceImpl implements InstituteService {

	@Autowired
	InstituteDao instDao;
	
	@Autowired
	private StorageService storageService;
	
	@Override
	public Institute saveName(Institute institute) {
		
		return instDao.save(institute);
	}

	@Override
	public void deleteInstitute(int id) {
		
		 instDao.deleteById(id);
	}

	@Override
	public List<Institute> findAllInstitute() {
		
		return instDao.findAll();
	}
	
	@Override
	public Institute saveInstitute(Institute institute, MultipartFile profilepicture) {
		
		String filename = storageService.store(profilepicture);
		institute.setProfilepicture(filename);
		return instDao.save(institute);
		
	}


}
