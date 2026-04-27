package com.clinique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinique.entites.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long>{

}
