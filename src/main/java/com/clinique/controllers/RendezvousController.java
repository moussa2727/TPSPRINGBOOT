package com.clinique.controllers;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.clinique.entites.RendezVous;
import com.clinique.repositories.MedecinRepository;
import com.clinique.repositories.PatientRepository;
import com.clinique.repositories.RDVRepository;

@Controller
public class RendezvousController implements CommandLineRunner {

    private final RDVRepository rdvRepository;
    private final PatientRepository patientRepository;
    private final MedecinRepository medecinRepository;

    public RendezvousController(RDVRepository rdvRepository, PatientRepository patientRepository,
            MedecinRepository medecinRepository) {
        this.rdvRepository = rdvRepository;
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
    }

    @GetMapping("/rdv/new")
    public String ajouterRendezVous(Model model) {
        RendezVous newRdv = new RendezVous();
        model.addAttribute("newRdv", newRdv);
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("medecins", medecinRepository.findAll());
        return "addrdv";
    }

    @PostMapping("/rdv/save")
    public String sauvegarderRendezVous(@ModelAttribute RendezVous newRdv) {
        rdvRepository.save(newRdv);
        return "redirect:/rdv/new";
    }

    @GetMapping("/")
    public String accueil(Model model) {
        model.addAttribute("rdvs", rdvRepository.findByDate(LocalDate.now()));
        model.addAttribute("today", LocalDate.now());
        return "RendezVousList";
    }

    @Override
    public void run(String... args) throws Exception {
        if (rdvRepository.count() == 0 && patientRepository.count() >= 3 && medecinRepository.count() >= 3) {
            RendezVous rdv3 = new RendezVous();
            rdv3.setIdRDV(3L);
            rdv3.setDate(LocalDate.of(2027, 5, 1));
            rdv3.setRemarque("Patient sain");
            rdv3.setPatient(patientRepository.findById(2L).orElse(null));
            rdv3.setMedecin(medecinRepository.findById(1L).orElse(null));

            RendezVous rdv4 = new RendezVous();
            rdv4.setIdRDV(4L);
            rdv4.setDate(LocalDate.of(2027, 1, 1));
            rdv4.setRemarque("Patient sain");
            rdv4.setPatient(patientRepository.findById(2L).orElse(null));
            rdv4.setMedecin(medecinRepository.findById(1L).orElse(null));

            RendezVous rdv5 = new RendezVous();
            rdv5.setIdRDV(5L);
            rdv5.setDate(LocalDate.of(2027, 4, 1));
            rdv5.setRemarque("Patient malade");
            rdv5.setPatient(patientRepository.findById(3L).orElse(null));
            rdv5.setMedecin(medecinRepository.findById(3L).orElse(null));

            if (rdv3.getPatient() != null && rdv3.getMedecin() != null)
                rdvRepository.save(rdv3);
            if (rdv4.getPatient() != null && rdv4.getMedecin() != null)
                rdvRepository.save(rdv4);
            if (rdv5.getPatient() != null && rdv5.getMedecin() != null)
                rdvRepository.save(rdv5);
        }
    }
}