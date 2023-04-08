package com.vanfx.alkemychallengebackend.services;

import com.vanfx.alkemychallengebackend.dto.GeneroDTO;
import com.vanfx.alkemychallengebackend.helpers.MensajeResponse;
import org.springframework.http.ResponseEntity;

public interface GeneroService {

    ResponseEntity<GeneroDTO>createGenero(GeneroDTO generoDTO);

    ResponseEntity<MensajeResponse> deleteGenero(Long id);
}
