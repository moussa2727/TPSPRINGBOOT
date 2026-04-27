package com.clinique.entites;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class RendezVous {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rdv")
	private long idRDV;
	private LocalDate date;
	@Column(length=100)
	private String remarque;
	@ManyToOne
	private Patient patient;
	@ManyToOne
	private Medecin medecin;
	public long getIdRDV() {
		return idRDV;
	}
	public void setIdRDV(long idRDV) {
		this.idRDV = idRDV;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	public RendezVous(long idRDV, LocalDate date, String remarque, Patient patient, Medecin medecin) {
		super();
		this.idRDV = idRDV;
		this.date = date;
		this.remarque = remarque;
		this.patient = patient;
		this.medecin = medecin;
	}
	public RendezVous() {
		super();
	}
	
	

}
