package com.isa_mrs.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa_mrs.project.model.Pharmacy;

@Repository
public interface PharmacyRepository  extends JpaRepository<Pharmacy, Long> {

}
