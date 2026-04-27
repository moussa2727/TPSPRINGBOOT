package com.clinique.entites;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Clinique {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clinique")
	private long idClinique;
	@Column(name="nom_clinique",length=50)
	private String nomClinique;
	@Column(length=50)
	private String adresse;
	@Column(length=10)
	private String tel;
	@ManyToMany
	@JoinTable(name="clinique-medecin",joinColumns=@JoinColumn(name="id_clique"),inverseJoinColumns=@JoinColumn(name="id_medecin"))
	private List<Medecin> medecins;
	public long getIdClinique() {
		return idClinique;
	}
	public void setIdClinique(long idClinique) {
		this.idClinique = idClinique;
	}
	public String getNomClinique() {
		return nomClinique;
	}
	public void setNomClinique(String nomClinique) {
		this.nomClinique = nomClinique;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<Medecin> getMedecins() {
		return medecins;
	}
	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}
	public Clinique(long idClinique, String nomClinique, String adresse, String tel, List<Medecin> medecins) {
		super();
		this.idClinique = idClinique;
		this.nomClinique = nomClinique;
		this.adresse = adresse;
		this.tel = tel;
		this.medecins = medecins;
	}
	public Clinique() {
		super();
	}
	
	

}
