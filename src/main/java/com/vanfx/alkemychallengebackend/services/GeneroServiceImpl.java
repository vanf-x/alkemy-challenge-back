package com.vanfx.alkemychallengebackend.services;

import com.vanfx.alkemychallengebackend.dto.GeneroDTO;
import com.vanfx.alkemychallengebackend.dto.GeneroMapper;
import com.vanfx.alkemychallengebackend.helpers.MensajeResponse;
import com.vanfx.alkemychallengebackend.model.Genero;
import com.vanfx.alkemychallengebackend.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    GeneroMapper generoMapper;

    @Autowired
    GeneroRepository generoRepository;

    @Override
    public ResponseEntity<GeneroDTO> createGenero(GeneroDTO generoDTO) {
        Genero generoExistente = generoRepository.findByNombre(generoDTO.getNombre());
        if(generoExistente != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(generoDTO);
        }
        Genero generoNuevo = generoMapper.toGenero(generoDTO);
        Genero guardarGenero = generoRepository.save(generoNuevo);
        GeneroDTO generoGuardadoDTO = generoMapper.toGeneroDTO(guardarGenero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardadoDTO);
    }

    @Override
    public ResponseEntity<MensajeResponse> deleteGenero(Long id) {
        Genero genero = generoRepository.findById(id)
                .orElse(null);
        if(genero == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensajeResponse("No se encontró el género solicitado"));
        }
        genero.setActivo(false);
        generoRepository.save(genero);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeResponse("Género borrado con éxito"));
    }


}
