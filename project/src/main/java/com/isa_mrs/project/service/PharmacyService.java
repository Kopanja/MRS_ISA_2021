package com.isa_mrs.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa_mrs.project.model.Pharmacy;
import com.isa_mrs.project.repository.PharmacyRepository;

@Service
public class PharmacyService {

	@Autowired
	PharmacyRepository pharmacyRepo;
	
	
	public List<Pharmacy> findAll(){
		return pharmacyRepo.findAll();
	}
}
