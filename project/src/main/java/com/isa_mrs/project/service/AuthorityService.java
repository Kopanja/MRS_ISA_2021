package com.isa_mrs.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa_mrs.project.model.Authority;
import com.isa_mrs.project.repository.AuthorityRepository;

@Service
public class AuthorityService {

	@Autowired
	AuthorityRepository authRepo;

	public Authority findByName(String role) {
		return authRepo.findByName(role);
	}
}
