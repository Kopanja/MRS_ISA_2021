package com.isa_mrs.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa_mrs.project.dto.PharmacyDTO;
import com.isa_mrs.project.model.Pharmacy;
import com.isa_mrs.project.service.PharmacyService;

@RestController
@CrossOrigin
@RequestMapping(value="api/pharmacies")
public class PharmacyController {

	@Autowired
	PharmacyService pharmacyService;
	
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PharmacyDTO>> getAllPharmacies() {
        
		List<Pharmacy> pharmacies = pharmacyService.findAll();
        return new ResponseEntity<>(toPharmacyDTOList(pharmacies), HttpStatus.OK);
    }
	
	private static List<PharmacyDTO> toPharmacyDTOList(List<Pharmacy> pharmacies) {
		List<PharmacyDTO> pharmacyDTOS = new ArrayList<>();
	       
        for (Pharmacy pharmacy: pharmacies) {
        	pharmacyDTOS.add(new PharmacyDTO(pharmacy.getId(), pharmacy.getName(), pharmacy.getAddress(), pharmacy.getDescription(), pharmacy.getRating()));
        }
        return pharmacyDTOS;
	}
	
	 
}
