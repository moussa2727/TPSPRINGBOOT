package com.clinique.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.clinique.entites.Clinique;
import com.clinique.entites.Medecin;
import com.clinique.repositories.CliniqueRepository;
import com.clinique.repositories.MedecinRepository;

@Controller
public class CliniqueController implements CommandLineRunner {
	@Autowired
	private CliniqueRepository cliniqueRepo;
	@Autowired
	private MedecinRepository medecinRepo;

	@GetMapping("/clinique/new")
	public String ajouterClinique(Model model) {
		Clinique newClinique = new Clinique();
		model.addAttribute("newClinique", newClinique);
		return "formAjoutClinique";
	}

	@PostMapping("/clinique/save")
	public String sauvegarderClinique(@ModelAttribute Clinique newClinique) {
		cliniqueRepo.save(newClinique);
		return "redirect:/clinique/new";
	}

	@GetMapping("/clinique/affecter")
	public String affecterMedecin(Model model) {
		model.addAttribute("cliniques", cliniqueRepo.findAll());
		model.addAttribute("medecins", medecinRepo.findAll());
		return "formAffecterMedecin";
	}

	@PostMapping("/clinique/affecter/save")
	public String sauvegarderAffectation(Long idClinique, Long idMedecin) {
		Clinique clinique = cliniqueRepo.findById(idClinique)
				.orElseThrow(() -> new IllegalArgumentException("Invalid clinique Id:" + idClinique));
		Medecin medecin = medecinRepo.findById(idMedecin)
				.orElseThrow(() -> new IllegalArgumentException("Invalid medecin Id:" + idMedecin));
		clinique.getMedecins().add(medecin);
		cliniqueRepo.save(clinique);
		return "redirect:/clinique/affecter";
	}

	@Override
	public void run(String... args) throws Exception {
		if (cliniqueRepo.count() == 0) {
			Clinique clinique1 = new Clinique();
			clinique1.setIdClinique(1L);
			clinique1.setNomClinique("Clinique ACHIFA");
			clinique1.setAdresse("BD 2 Mars Casablanca");
			clinique1.setTel("0522258723");

			Clinique clinique2 = new Clinique();
			clinique2.setIdClinique(2L);
			clinique2.setNomClinique("Clinique La Source");
			clinique2.setAdresse("BD Zerkouri Casablanca");
			clinique2.setTel("0522479723");

			cliniqueRepo.save(clinique1);
			cliniqueRepo.save(clinique2);
		}
	}
}