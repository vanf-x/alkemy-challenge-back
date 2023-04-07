package com.vanfx.alkemychallengebackend.controller;

import com.vanfx.alkemychallengebackend.dto.GeneroDTO;
import com.vanfx.alkemychallengebackend.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class GeneroController {

    @Autowired
    GeneroService generoService;

    @PostMapping("/generos")
    public ResponseEntity<GeneroDTO> crearGenero(@RequestBody GeneroDTO generoDTO) {
        ResponseEntity<GeneroDTO> response = generoService.createGenero(generoDTO);
        return response;
    }

}
