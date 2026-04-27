package com.clinique.entites;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_patient")
	private long idPatient;
	@Column(length=50)
	private String nom;
	@Column(length=10)
	private String tel;
	private LocalDate dateNaissance;
	@OneToMany(mappedBy="patient")
	private List<RendezVous> rdvs;
	public long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(long idPatient) {
		this.idPatient = idPatient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public List<RendezVous> getRdvs() {
		return rdvs;
	}
	public void setRdvs(List<RendezVous> rdvs) {
		this.rdvs = rdvs;
	}
	public Patient(long idPatient, String nom, String tel, LocalDate dateNaissance, List<RendezVous> rdvs) {
		super();
		this.idPatient = idPatient;
		this.nom = nom;
		this.tel = tel;
		this.dateNaissance = dateNaissance;
		this.rdvs = rdvs;
	}
	public Patient() {
		super();
	}
	
	

}
