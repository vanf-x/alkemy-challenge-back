package com.vanfx.alkemychallengebackend.services;

import com.vanfx.alkemychallengebackend.dto.PersonajeDTO;
import com.vanfx.alkemychallengebackend.model.Personaje;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonajeService {

    ResponseEntity<List<PersonajeDTO>> getAllPersonajes();
    public ResponseEntity<PersonajeDTO> getPersonajeById(Long id);
    public ResponseEntity<PersonajeDTO> createPersonaje(PersonajeDTO personajeDTO);

    public ResponseEntity<PersonajeDTO> deletePersonaje(Long id);
}
