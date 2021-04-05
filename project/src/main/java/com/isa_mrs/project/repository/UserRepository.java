package com.isa_mrs.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa_mrs.project.model.User;


@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
