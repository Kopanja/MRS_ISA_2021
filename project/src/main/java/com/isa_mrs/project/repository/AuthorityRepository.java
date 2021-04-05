package com.isa_mrs.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa_mrs.project.model.Authority;

@Repository
public interface AuthorityRepository  extends JpaRepository<Authority, Long> {

	Authority findByName(String role);

}
