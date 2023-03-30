package com.vanfx.alkemychallengebackend.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super();
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
