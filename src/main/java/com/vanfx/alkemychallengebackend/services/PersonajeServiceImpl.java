package com.vanfx.alkemychallengebackend.services;

import com.vanfx.alkemychallengebackend.dto.PeliculaDTO;
import com.vanfx.alkemychallengebackend.dto.PersonajeDTO;
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
    PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDTO> getAllPersonajes() {
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        List<Personaje> personajes = personajeRepository.findAll();
        for(Personaje personaje : personajes){
            PersonajeDTO personajeDTO = new PersonajeDTO();
            personajeDTO.setId(personaje.getId());
            personajeDTO.setImagen(personaje.getImagen());
            personajeDTO.setNombre(personaje.getNombre());
            personajeDTO.setEdad(personaje.getEdad());
            personajeDTO.setPeso(personaje.getPeso());
            personajeDTO.setHistoria(personaje.getHistoria());
            List<PeliculaDTO> peliculasDTO = new ArrayList<>();
            for (Pelicula pelicula : personaje.getPeliculas()) {
                PeliculaDTO peliculaDTO = new PeliculaDTO();
                peliculaDTO.setId(pelicula.getId());
                peliculaDTO.setImagen(pelicula.getImagen());
                peliculaDTO.setTitulo(pelicula.getTitulo());
                peliculaDTO.setFechaDeCreacion(pelicula.getFechaDeCreacion());
                peliculaDTO.setCalificacion(pelicula.getCalificacion());
                peliculasDTO.add(peliculaDTO);
            }
            personajeDTO.setPeliculas(peliculasDTO);
            personajesDTO.add(personajeDTO);
        }
        return personajesDTO;
    }

    @Override
    public PersonajeDTO getPersonajeById(Long id) {
        Personaje personaje = personajeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personaje no encontrado"));
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setId(personaje.getId());
        personajeDTO.setImagen(personaje.getImagen());
        personajeDTO.setNombre(personaje.getNombre());
        personajeDTO.setEdad(personaje.getEdad());
        personajeDTO.setPeso(personaje.getPeso());
        personajeDTO.setHistoria(personaje.getHistoria());
        List<PeliculaDTO> peliculasDTO = new ArrayList<>();
        for (Pelicula pelicula : personaje.getPeliculas()) {
            PeliculaDTO peliculaDTO = new PeliculaDTO();
            peliculaDTO.setId(pelicula.getId());
            peliculaDTO.setImagen(pelicula.getImagen());
            peliculaDTO.setTitulo(pelicula.getTitulo());
            peliculaDTO.setFechaDeCreacion(pelicula.getFechaDeCreacion());
            peliculaDTO.setCalificacion(pelicula.getCalificacion());
            peliculasDTO.add(peliculaDTO);
        }
        personajeDTO.setPeliculas(peliculasDTO);
        return personajeDTO;
    }
}
