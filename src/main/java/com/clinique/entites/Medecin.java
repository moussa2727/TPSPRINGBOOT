package com.clinique.entites;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Medecin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_medecin")
	private long idMedecin;
	@Column(length=50)
	private String nom;
	@Column(length=50)
	private String specialite;
	@Column(length=10)
	private String tel;
	@Column(name="prix_consultation")
	private double prixConsultation;
	@OneToMany(mappedBy="medecin")
	private List<RendezVous> rdvs;
	@ManyToMany(mappedBy="medecins")
	private List<Clinique> cliniques;
	public long getIdMedecin() {
		return idMedecin;
	}
	public void setIdMedecin(long idMedecin) {
		this.idMedecin = idMedecin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public double getPrixConsultation() {
		return prixConsultation;
	}
	public void setPrixConsultation(double prixConsultation) {
		this.prixConsultation = prixConsultation;
	}
	public List<RendezVous> getRdvs() {
		return rdvs;
	}
	public void setRdvs(List<RendezVous> rdvs) {
		this.rdvs = rdvs;
	}
	public List<Clinique> getCliniques() {
		return cliniques;
	}
	public void setCliniques(List<Clinique> cliniques) {
		this.cliniques = cliniques;
	}
	public Medecin(long idMedecin, String nom, String specialite, String tel, double prixConsultation,
			List<RendezVous> rdvs, List<Clinique> cliniques) {
		super();
		this.idMedecin = idMedecin;
		this.nom = nom;
		this.specialite = specialite;
		this.tel = tel;
		this.prixConsultation = prixConsultation;
		this.rdvs = rdvs;
		this.cliniques = cliniques;
	}
	public Medecin() {
		super();
	}
	
	

}
