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
    public List<PersonajeDTO> getAllPersonajes() {
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        List<Personaje> personajes = personajeRepository.findAll();
        for (Personaje personaje : personajes) {
            personajesDTO.add(personajeMapper.toPersonajeDTO(personaje));
        }
        return personajesDTO;
    }

    @Override
    public PersonajeDTO getPersonajeById(Long id) {
        Personaje personaje = personajeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personaje no encontrado"));
        PersonajeDTO personajeDTO = personajeMapper.toPersonajeDTO(personaje);
        return personajeDTO;
    }


    @Override
    public PersonajeDTO crearPersonaje(Personaje personaje) {
        return null;
    }
}
