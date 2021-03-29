package com.isa_mrs.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="type", length = 50)
	private String type;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "pharmacy_id")
	private Pharmacy pharmacy;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<Examination> examinations;
	
	
	
	
	public Employee() {
		super();
	}




	public Employee(Long id, String type, User user) {
		super();
		this.id = id;
		this.type = type;
		this.user = user;
	}


	


	public Employee(Long id, String type, User user, Pharmacy pharmacy, Set<Examination> examinations) {
		super();
		this.id = id;
		this.type = type;
		this.user = user;
		this.pharmacy = pharmacy;
		this.examinations = examinations;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public Pharmacy getPharmacy() {
		return pharmacy;
	}




	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}




	public Set<Examination> getExaminations() {
		return examinations;
	}




	public void setExaminations(Set<Examination> examinations) {
		this.examinations = examinations;
	}
	
	
	
}
