package com.clinique.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinique.entites.RendezVous;

public interface RDVRepository extends JpaRepository<RendezVous, Long> {
    List<RendezVous> findByDate(LocalDate date);
}
