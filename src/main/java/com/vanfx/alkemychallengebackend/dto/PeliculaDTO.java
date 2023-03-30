package com.vanfx.alkemychallengebackend.dto;

import com.vanfx.alkemychallengebackend.model.Genero;
import com.vanfx.alkemychallengebackend.model.Personaje;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDTO {
    private Long id;
    private String imagen;
    private String titulo;
    private LocalDate fechaDeCreacion;
    private Integer calificacion;
    private List<PersonajeDTO> personajes = new ArrayList<>();
    private Genero genero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public List<PersonajeDTO> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<PersonajeDTO> personajes) {
        this.personajes = personajes;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}