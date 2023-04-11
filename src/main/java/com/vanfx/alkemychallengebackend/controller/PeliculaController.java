package com.vanfx.alkemychallengebackend.controller;

import com.vanfx.alkemychallengebackend.dto.PeliculaDTO;
import com.vanfx.alkemychallengebackend.helpers.MensajeResponse;
import com.vanfx.alkemychallengebackend.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/peliculas")
    public ResponseEntity<List<PeliculaDTO>> getAllPeliculas() {
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/peliculas/{id}")
    public ResponseEntity<PeliculaDTO> getPeliculaById(@PathVariable Long id) {
        return peliculaService.getPeliculaById(id);
    }

    @PostMapping("/peliculas")
    public ResponseEntity<PeliculaDTO> createPelicula(@RequestBody PeliculaDTO peliculaDTO) {
        ResponseEntity<PeliculaDTO> response = peliculaService.createPelicula(peliculaDTO);
        return response;
    }

    @DeleteMapping("/peliculas/{id}")
    public ResponseEntity<MensajeResponse> deletePelicula(@PathVariable Long id) {
        return peliculaService.deletePelicula(id);
    }

    @PutMapping("/peliculas/{id}")
    public ResponseEntity<MensajeResponse> editPelicula(@RequestBody Long id, @RequestBody PeliculaDTO peliculaDTO) {
        return peliculaService.editPelicula(id, peliculaDTO);
    }
}
