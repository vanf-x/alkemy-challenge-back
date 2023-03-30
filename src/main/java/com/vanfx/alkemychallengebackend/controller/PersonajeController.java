package com.vanfx.alkemychallengebackend.controller;

import com.vanfx.alkemychallengebackend.dto.PersonajeDTO;
import com.vanfx.alkemychallengebackend.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/personajes")
    public List<PersonajeDTO> getAllPersonajes(){
        return personajeService.getAllPersonajes();
    }

    @GetMapping("/personajes/{id}")
    public PersonajeDTO getPErsonajeById(@PathVariable Long id){
        return personajeService.getPersonajeById(id);
    }
}
