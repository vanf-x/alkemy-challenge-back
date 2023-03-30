package com.vanfx.alkemychallengebackend.services;

import com.vanfx.alkemychallengebackend.dto.PeliculaDTO;
import com.vanfx.alkemychallengebackend.dto.PersonajeDTO;
import com.vanfx.alkemychallengebackend.exceptions.ResourceNotFoundException;
import com.vanfx.alkemychallengebackend.model.Pelicula;
import com.vanfx.alkemychallengebackend.model.Personaje;
import com.vanfx.alkemychallengebackend.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService{

    @Autowired
    PeliculaRepository peliculaRepository;

    @Override
    public PeliculaDTO getPeliculaById(Long id) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Película no encontrada"));
        PeliculaDTO peliculaDTO = new PeliculaDTO();
        peliculaDTO.setId(pelicula.getId());
        peliculaDTO.setImagen(pelicula.getImagen());
        peliculaDTO.setTitulo(pelicula.getTitulo());
        peliculaDTO.setFechaDeCreacion(pelicula.getFechaDeCreacion());
        peliculaDTO.setCalificacion(pelicula.getCalificacion());
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        for(Personaje personaje : pelicula.getPersonajes()){
            PersonajeDTO personajeDTO = new PersonajeDTO();
            personajeDTO.setId(personaje.getId());
            personajeDTO.setImagen(personaje.getImagen());
            personajeDTO.setNombre(personaje.getNombre());
            personajeDTO.setEdad(personaje.getEdad());
            personajeDTO.setPeso(personaje.getPeso());
            personajeDTO.setHistoria(personaje.getHistoria());
            personajesDTO.add(personajeDTO);
        }
        peliculaDTO.setPersonajes(personajesDTO);
        return peliculaDTO;
    }
}
