package com.vanfx.alkemychallengebackend.services;

import com.vanfx.alkemychallengebackend.dto.GeneroDTO;
import org.springframework.http.ResponseEntity;

public interface GeneroService {

    ResponseEntity<GeneroDTO>createGenero(GeneroDTO generoDTO);
}
