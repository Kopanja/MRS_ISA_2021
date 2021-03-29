package com.isa_mrs.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EXAMINATION")
public class Examination {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "pharmacy_id")
	private Pharmacy pharmacy;
	
	
	public Examination() {
		super();
	}



	public Examination(Long id, Employee employee, Patient patient) {
		super();
		this.id = id;
		this.employee = employee;
		this.patient = patient;
	}


	

	public Examination(Long id, Employee employee, Patient patient, Pharmacy pharmacy) {
		super();
		this.id = id;
		this.employee = employee;
		this.patient = patient;
		this.pharmacy = pharmacy;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public Pharmacy getPharmacy() {
		return pharmacy;
	}



	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}




	

}
