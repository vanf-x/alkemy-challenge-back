package com.vanfx.alkemychallengebackend.helpers;

public class MensajeResponse {
    private String mensaje;

    public MensajeResponse(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
