package com.vanfx.alkemychallengebackend.services;

import com.vanfx.alkemychallengebackend.dto.PeliculaDTO;
import com.vanfx.alkemychallengebackend.dto.PersonajeDTO;
import com.vanfx.alkemychallengebackend.dto.PersonajeMapper;
import com.vanfx.alkemychallengebackend.exceptions.ResourceNotFoundException;
import com.vanfx.alkemychallengebackend.model.Pelicula;
import com.vanfx.alkemychallengebackend.model.Personaje;
import com.vanfx.alkemychallengebackend.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    PersonajeMapper personajeMapper;

    @Autowired
    PersonajeRepository personajeRepository;

    @Override
    public ResponseEntity<List<PersonajeDTO>> getAllPersonajes() {
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        List<Personaje> personajes = personajeRepository.findAll();
        for (Personaje personaje : personajes) {
            personajesDTO.add(personajeMapper.toPersonajeDTO(personaje));
        }
        return ResponseEntity.ok(personajesDTO);
    }

    @Override
    public ResponseEntity<PersonajeDTO> getPersonajeById(Long id) {
        Personaje personaje = personajeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personaje no encontrado"));
        PersonajeDTO personajeDTO = personajeMapper.toPersonajeDTO(personaje);
        return ResponseEntity.ok(personajeDTO);
    }

    @Override
    public ResponseEntity<PersonajeDTO> createPersonaje(PersonajeDTO personajeDTO) {
        Personaje personaje = personajeMapper.toPersonaje(personajeDTO);
        Personaje guardarPersonaje = personajeRepository.save(personaje);
        PersonajeDTO personajeGuardadoDTO = personajeMapper.toPersonajeDTO(guardarPersonaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardadoDTO);
    }

    @Override
    public ResponseEntity<PersonajeDTO> deletePersonaje(Long id) {
        return null;
    }


}
