/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Analia
 */
public class dtoEducacion {

    @NotBlank
    private String escuela;
    @NotBlank
    private String titulo;
    private String imagen;
    @NotBlank
    private String carrera;
    private String puntaje;
    @NotBlank
    private String inicio;
    @NotBlank
    private String fin;

    public dtoEducacion() {
    }

    public dtoEducacion(String escuela, String titulo, String imagen, String carrera, String puntaje, String inicio, String fin) {
        this.escuela = escuela;
        this.titulo = titulo;
        this.imagen = imagen;
        this.carrera = carrera;
        this.puntaje = puntaje;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

}
