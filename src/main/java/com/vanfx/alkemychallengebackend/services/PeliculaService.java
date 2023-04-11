package com.vanfx.alkemychallengebackend.services;

import com.vanfx.alkemychallengebackend.dto.PeliculaDTO;
import com.vanfx.alkemychallengebackend.helpers.MensajeResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PeliculaService {
    ResponseEntity<List<PeliculaDTO>> getAllPeliculas();
    ResponseEntity<PeliculaDTO> getPeliculaById(Long id);
    ResponseEntity<PeliculaDTO> createPelicula(PeliculaDTO peliculaDTO);
    ResponseEntity<MensajeResponse> deletePelicula(Long id);
    ResponseEntity<MensajeResponse> editPelicula(Long id, PeliculaDTO peliculaDTO);
}
