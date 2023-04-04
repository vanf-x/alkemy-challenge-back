package com.vanfx.alkemychallengebackend.dto;

import com.vanfx.alkemychallengebackend.model.Pelicula;
import com.vanfx.alkemychallengebackend.model.Personaje;
import com.vanfx.alkemychallengebackend.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeMapper {

    PeliculaRepository peliculaRepository;

    @Autowired
    public PersonajeMapper(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }


    public Personaje toPersonaje(PersonajeDTO personajeDTO) {
        Personaje personaje = new Personaje();
        personaje.setId(personajeDTO.getId());
        personaje.setNombre(personajeDTO.getNombre());
        personaje.setImagen(personajeDTO.getImagen());
        personaje.setEdad(personajeDTO.getEdad());
        personaje.setPeso(personajeDTO.getPeso());
        personaje.setHistoria(personajeDTO.getHistoria());
        List<Pelicula> peliculas = new ArrayList<>();
        for (String nombrePelicula : personajeDTO.getPeliculas()) {
            Pelicula pelicula = peliculaRepository.findByTitulo(nombrePelicula);
            peliculas.add(pelicula);
        }
        personaje.setPeliculas(peliculas);
        return personaje;
    }

    public PersonajeDTO toPersonajeDTO(Personaje personaje) {
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setId(personaje.getId());
        personajeDTO.setNombre(personaje.getNombre());
        personajeDTO.setImagen(personaje.getImagen());
        personajeDTO.setEdad(personaje.getEdad());
        personajeDTO.setPeso(personaje.getPeso());
        personajeDTO.setHistoria(personaje.getHistoria());
        List<String> peliculas = new ArrayList<>();
        for (Pelicula pelicula : personaje.getPeliculas()) {
            String nombrePelicula = pelicula.getTitulo();
            peliculas.add(nombrePelicula);
        }
        personajeDTO.setPeliculas(peliculas);
        return personajeDTO;
    }
}

