package com.isa_mrs.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="MEDICINE_IN_PHARMACY")
public class MedicineInPharmacy {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "medicine_id")
	private Medicine medicine;
	
	@ManyToOne
    @JoinColumn(name = "pharmacy_id")
	private Pharmacy pharmacy;
	
	@Column(name= "amount")
	private int amountAvaliable;

	
	public MedicineInPharmacy() {
		super();
	}


	public MedicineInPharmacy(Long id) {
		super();
		this.id = id;
	}


	
	public MedicineInPharmacy(Long id, Medicine medicine, Pharmacy pharmacy, int amountAvaliable) {
		super();
		this.id = id;
		this.medicine = medicine;
		this.pharmacy = pharmacy;
		this.amountAvaliable = amountAvaliable;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Medicine getMedicine() {
		return medicine;
	}


	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}


	public Pharmacy getPharmacy() {
		return pharmacy;
	}


	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}


	public int getAmountAvaliable() {
		return amountAvaliable;
	}


	public void setAmountAvaliable(int amountAvaliable) {
		this.amountAvaliable = amountAvaliable;
	}
	
	
	
}
