package com.vanfx.alkemychallengebackend.dto;

import com.vanfx.alkemychallengebackend.model.Genero;
import com.vanfx.alkemychallengebackend.model.Pelicula;
import com.vanfx.alkemychallengebackend.model.Personaje;
import com.vanfx.alkemychallengebackend.repository.GeneroRepository;
import com.vanfx.alkemychallengebackend.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaMapper {

    private PersonajeRepository personajeRepository;
    private GeneroRepository generoRepository;

    @Autowired
    public PeliculaMapper(PersonajeRepository personajeRepository, GeneroRepository generoRepository) {
        this.personajeRepository = personajeRepository;
        this.generoRepository = generoRepository;
    }

    public Pelicula toPelicula(PeliculaDTO peliculaDTO) {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(peliculaDTO.getId());
        pelicula.setImagen(peliculaDTO.getImagen());
        pelicula.setTitulo(peliculaDTO.getTitulo());
        pelicula.setFechaDeCreacion(peliculaDTO.getFechaDeCreacion());
        pelicula.setCalificacion(peliculaDTO.getCalificacion());
        pelicula.setActivo(peliculaDTO.getActivo());
        List<Personaje> personajes = new ArrayList<>();
        for (String nombrePersonaje : peliculaDTO.getPersonajes()) {
            Personaje personaje = personajeRepository.findByNombre(nombrePersonaje);
            personajes.add(personaje);
        }
        pelicula.setPersonajes(personajes);
        Genero genero = generoRepository.findByNombre(peliculaDTO.getGenero());
        pelicula.setGenero(genero);
        return pelicula;
    }

    public PeliculaDTO toPeliculaDTO(Pelicula pelicula) {
        PeliculaDTO peliculaDTO = new PeliculaDTO();
        peliculaDTO.setId(pelicula.getId());
        peliculaDTO.setImagen(pelicula.getImagen());
        peliculaDTO.setTitulo(pelicula.getTitulo());
        peliculaDTO.setFechaDeCreacion(pelicula.getFechaDeCreacion());
        peliculaDTO.setCalificacion(pelicula.getCalificacion());
        peliculaDTO.setActivo(pelicula.getActivo());
        List<String> personajes = new ArrayList<>();
        for (Personaje personaje : pelicula.getPersonajes()) {
            String nombrePersonaje = personaje.getNombre();
            personajes.add(nombrePersonaje);
        }
        peliculaDTO.setPersonajes(personajes);
        Genero genero = generoRepository.findByNombre(pelicula.getGenero().getNombre());
        peliculaDTO.setGenero(genero.getNombre());
        return peliculaDTO;
    }

}
