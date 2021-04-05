package com.isa_mrs.project.dto;

public class MedicineDTO {

	private Long id;
	
	private String name;

	
	public MedicineDTO() {
	}


	public MedicineDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
