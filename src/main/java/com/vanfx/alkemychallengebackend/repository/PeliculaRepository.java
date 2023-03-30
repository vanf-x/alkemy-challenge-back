package com.vanfx.alkemychallengebackend.repository;

import com.vanfx.alkemychallengebackend.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
