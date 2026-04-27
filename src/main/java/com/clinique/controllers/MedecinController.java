package com.clinique.controllers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.clinique.entites.Medecin;
import com.clinique.repositories.MedecinRepository;

@Controller
public class MedecinController implements CommandLineRunner {

    private final MedecinRepository medecinRepository;

    public MedecinController(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    @GetMapping("/medecin/new")
    public String ajouterMedecin(Model model) {
        Medecin newMedecin = new Medecin();
        model.addAttribute("newMedecin", newMedecin);
        return "addmedecin";
    }

    @PostMapping("/medecin/save")
    public String sauvegarderMedecin(@ModelAttribute Medecin newMedecin) {
        medecinRepository.save(newMedecin);
        return "redirect:/medecin/new";
    }

    @Override
    public void run(String... args) throws Exception {
        if (medecinRepository.count() == 0) {
            Medecin medecin1 = new Medecin();
            medecin1.setIdMedecin(1L);
            medecin1.setNom("Mohamed TOUNSI");
            medecin1.setPrixConsultation(300);
            medecin1.setSpecialite("Cardiologue");
            medecin1.setTel("0522219095");

            Medecin medecin2 = new Medecin();
            medecin2.setIdMedecin(2L);
            medecin2.setNom("Halima BEN KHALIFA");
            medecin2.setPrixConsultation(300);
            medecin2.setSpecialite("Dermatologue");
            medecin2.setTel("0522320478");

            Medecin medecin3 = new Medecin();
            medecin3.setIdMedecin(3L);
            medecin3.setNom("Kenza BEDAOUD");
            medecin3.setPrixConsultation(300);
            medecin3.setSpecialite("Gynécologue");
            medecin3.setTel("0522287127");

            medecinRepository.save(medecin1);
            medecinRepository.save(medecin2);
            medecinRepository.save(medecin3);
        }
    }
}