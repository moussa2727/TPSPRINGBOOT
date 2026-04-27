package com.clinique.controllers;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.clinique.entites.Patient;
import com.clinique.repositories.PatientRepository;

@Controller
public class PatientController implements CommandLineRunner {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patient/new")
    public String ajouterPatient(Model model) {
        Patient newPatient = new Patient();
        model.addAttribute("newPatient", newPatient);
        return "addpatient";
    }

    @PostMapping("/patient/save")
    public String sauvegarderPatient(@ModelAttribute Patient newPatient) {
        patientRepository.save(newPatient);
        return "redirect:/patient/new";
    }

    @Override
    public void run(String... args) throws Exception {
        if (patientRepository.count() == 0) {
            Patient patient1 = new Patient();
            patient1.setIdPatient(1L);
            patient1.setNom("ALAOUI Mostapha");
            patient1.setTel("0874531243");
            patient1.setDateNaissance(LocalDate.of(1998, 2, 1));

            Patient patient2 = new Patient();
            patient2.setIdPatient(2L);
            patient2.setNom("ALAMI Mohamed");
            patient2.setTel("0698755241");
            patient2.setDateNaissance(LocalDate.of(1996, 2, 1));

            Patient patient3 = new Patient();
            patient3.setIdPatient(3L);
            patient3.setNom("SLIMANI Aya");
            patient3.setTel("0645132987");
            patient3.setDateNaissance(LocalDate.of(1978, 4, 8));

            patientRepository.save(patient1);
            patientRepository.save(patient2);
            patientRepository.save(patient3);
        }
    }
}