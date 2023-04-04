package com.vanfx.alkemychallengebackend.services;

import com.vanfx.alkemychallengebackend.dto.PersonajeDTO;
import com.vanfx.alkemychallengebackend.model.Personaje;

import java.util.List;

public interface PersonajeService {

    List<PersonajeDTO> getAllPersonajes();
    PersonajeDTO getPersonajeById(Long id);

    PersonajeDTO crearPersonaje(Personaje personaje);
}
