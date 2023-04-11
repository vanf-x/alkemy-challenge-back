package com.vanfx.alkemychallengebackend.services;

import com.vanfx.alkemychallengebackend.dto.PeliculaDTO;
import com.vanfx.alkemychallengebackend.dto.PeliculaMapper;
import com.vanfx.alkemychallengebackend.dto.PersonajeDTO;
import com.vanfx.alkemychallengebackend.exceptions.ResourceNotFoundException;
import com.vanfx.alkemychallengebackend.helpers.MensajeResponse;
import com.vanfx.alkemychallengebackend.model.Pelicula;
import com.vanfx.alkemychallengebackend.model.Personaje;
import com.vanfx.alkemychallengebackend.repository.PeliculaRepository;
import com.vanfx.alkemychallengebackend.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    PeliculaMapper peliculaMapper;

    @Override
    public ResponseEntity<List<PeliculaDTO>> getAllPeliculas() {
        List<PeliculaDTO> peliculasDTO = new ArrayList<>();
        List<Pelicula> peliculas = peliculaRepository.findAll();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getActivo()) {
                peliculasDTO.add(peliculaMapper.toPeliculaDTO(pelicula));
            }
        }
        return ResponseEntity.ok(peliculasDTO);
    }

    @Override
    public ResponseEntity<PeliculaDTO> getPeliculaById(Long id) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado esa película"));
        PeliculaDTO peliculaDTO = peliculaMapper.toPeliculaDTO(pelicula);
        return ResponseEntity.ok(peliculaDTO);

    }

    @Override
    public ResponseEntity<PeliculaDTO> createPelicula(PeliculaDTO peliculaDTO) {
        Pelicula pelicula = peliculaMapper.toPelicula(peliculaDTO);
        Pelicula guardarPelicula = peliculaRepository.save(pelicula);
        PeliculaDTO peliculaGuardadaDTO = peliculaMapper.toPeliculaDTO(guardarPelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardadaDTO);
    }

    @Override
    public ResponseEntity<MensajeResponse> deletePelicula(Long id) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElse(null);
        if (pelicula == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensajeResponse("No se encontró la película solicitada"));
        }
        pelicula.setActivo(false);
        peliculaRepository.save(pelicula);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeResponse("Película borrada con éxito"));
    }

    @Override
    public ResponseEntity<MensajeResponse> editPelicula(Long id, PeliculaDTO peliculaDTO) {
        Pelicula pelicula = peliculaRepository.findById(id).orElse(null);
        if(pelicula == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensajeResponse("No se encontró la película solicitada"));
        }
        pelicula = peliculaMapper.toPelicula(peliculaDTO);
        peliculaRepository.save(pelicula);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeResponse("Película editada con éxito"));
    }
}
