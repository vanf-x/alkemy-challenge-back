package com.vanfx.alkemychallengebackend.controller;

import com.vanfx.alkemychallengebackend.dto.PersonajeDTO;
import com.vanfx.alkemychallengebackend.helpers.MensajeResponse;
import com.vanfx.alkemychallengebackend.model.Personaje;
import com.vanfx.alkemychallengebackend.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/personajes")
    public ResponseEntity<List<PersonajeDTO>> getAllPersonajes() {
        return personajeService.getAllPersonajes();
    }

    @GetMapping("/personajes/{id}")
    public ResponseEntity<PersonajeDTO> getPersonajeById(@PathVariable Long id) {
        return personajeService.getPersonajeById(id);
    }

    @PostMapping("/personajes")
    public ResponseEntity<PersonajeDTO> crearPersonaje(@RequestBody PersonajeDTO personajeDTO) {
        ResponseEntity<PersonajeDTO> response = personajeService.createPersonaje(personajeDTO);
        return response;
    }

    @DeleteMapping("/personajes/{id}")
    public ResponseEntity<MensajeResponse> deletePersonaje(@PathVariable Long id) {
        return personajeService.deletePersonaje(id);
    }
}
