package com.clinique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinique.entites.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {

}
