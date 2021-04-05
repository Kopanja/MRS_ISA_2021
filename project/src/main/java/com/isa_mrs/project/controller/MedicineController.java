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

import com.isa_mrs.project.dto.MedicineDTO;
import com.isa_mrs.project.model.Medicine;
import com.isa_mrs.project.service.MedicineService;

@RestController
@CrossOrigin
@RequestMapping(value="api/medicine")
public class MedicineController {
	
	@Autowired
	MedicineService medicineService;
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MedicineDTO>> getAllMedicine() {
        
		List<Medicine> medicineList = medicineService.findAll();
        return new ResponseEntity<>(toMedicineDTOList(medicineList), HttpStatus.OK);
    }
	
	private static List<MedicineDTO> toMedicineDTOList(List<Medicine> medecineList) {
		List<MedicineDTO> medicineDTOS = new ArrayList<>();
	       
        for (Medicine medicine: medecineList) {
        	medicineDTOS.add(new MedicineDTO(medicine.getId(), medicine.getName()));
        }
        return medicineDTOS;
	}
	

}
