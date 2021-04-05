package com.isa_mrs.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa_mrs.project.model.Medicine;
import com.isa_mrs.project.repository.MedicineRepository;

@Service
public class MedicineService {

	@Autowired
	MedicineRepository medicineRepo;
	
	
	public List<Medicine> findAll(){
		return medicineRepo.findAll();
	}
}
