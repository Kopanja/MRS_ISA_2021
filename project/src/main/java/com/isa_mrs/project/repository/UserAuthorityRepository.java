package com.isa_mrs.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa_mrs.project.model.UserAuthority;

@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {

	UserAuthority findByAuthorityIdAndUserId(Long id, Long id2);

}
