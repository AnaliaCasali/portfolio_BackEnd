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
public class dtoProyecto {
    
 @NotBlank
    private String nombre;
    @NotBlank
    private String puesto;
    private String imagen;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String inicio;
    @NotBlank
    private String fin;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombre,  String descripcion, String inicio, String fin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
