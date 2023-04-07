package com.vanfx.alkemychallengebackend.dto;

import com.vanfx.alkemychallengebackend.model.Genero;
import com.vanfx.alkemychallengebackend.model.Pelicula;
import com.vanfx.alkemychallengebackend.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {

    PeliculaRepository peliculaRepository;

    @Autowired
    public GeneroMapper(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public Genero toGenero(GeneroDTO generoDTO) {
        Genero genero = new Genero();
        genero.setId(generoDTO.getId());
        genero.setNombre(generoDTO.getNombre());
        genero.setImagen(generoDTO.getImagen());
        List<Pelicula> peliculas = new ArrayList<>();
        for (String nombrePelicula : generoDTO.getPeliculas()) {
            Pelicula pelicula = peliculaRepository.findByTitulo(nombrePelicula);
            peliculas.add(pelicula);
        }
        genero.setPeliculas(peliculas);
        return genero;
    }

    public GeneroDTO toGeneroDTO(Genero genero) {
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setId(genero.getId());
        generoDTO.setNombre(genero.getNombre());
        generoDTO.setImagen(genero.getImagen());
        List<String> peliculas = new ArrayList<>();
        for (Pelicula pelicula : genero.getPeliculas()) {
            String nombrePelicula = pelicula.getTitulo();
            peliculas.add(nombrePelicula);
        }
        generoDTO.setPeliculas(peliculas);
        return generoDTO;
    }
}
