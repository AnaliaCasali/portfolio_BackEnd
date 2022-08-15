/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Analia
 */
@Entity
public class Perfil {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombres;
    private String apellido;
    private String fecha_nacimiento ;
    private String nacionalidad;
    private String mail;
    private String sobreMi;
    private String ocupacion;
    private String image_background_header;    
    private String image_perfil;    
    private String domicilio;
    private String linkedin;    
    private String github;
    private String telefono;
    private String dni;

    public Perfil() {
    }

    public Perfil(String nombres, String apellido, String fecha_nacimiento, String nacionalidad, String mail, String sobreMi, String ocupacion, String image_background_header, String image_perfil, String domicilio, String linkedin, String github, String telefono, String dni) {
        this.nombres = nombres;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.mail = mail;
        this.sobreMi = sobreMi;
        this.ocupacion = ocupacion;
        this.image_background_header = image_background_header;
        this.image_perfil = image_perfil;
        this.domicilio = domicilio;
        this.linkedin = linkedin;
        this.github = github;
        this.telefono = telefono;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSobreMi() {
        return sobreMi;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getImage_background_header() {
        return image_background_header;
    }

    public void setImage_background_header(String image_background_header) {
        this.image_background_header = image_background_header;
    }

    public String getImage_perfil() {
        return image_perfil;
    }

    public void setImage_perfil(String image_perfil) {
        this.image_perfil = image_perfil;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}