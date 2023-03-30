package com.vanfx.alkemychallengebackend.repository;

import com.vanfx.alkemychallengebackend.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
