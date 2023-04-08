package com.vanfx.alkemychallengebackend.services;

import com.vanfx.alkemychallengebackend.dto.PersonajeDTO;
import com.vanfx.alkemychallengebackend.helpers.MensajeResponse;
import com.vanfx.alkemychallengebackend.model.Personaje;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonajeService {

     ResponseEntity<List<PersonajeDTO>> getAllPersonajes();
     ResponseEntity<PersonajeDTO> getPersonajeById(Long id);
     ResponseEntity<PersonajeDTO> createPersonaje(PersonajeDTO personajeDTO);
     ResponseEntity<MensajeResponse> deletePersonaje(Long id);
}
