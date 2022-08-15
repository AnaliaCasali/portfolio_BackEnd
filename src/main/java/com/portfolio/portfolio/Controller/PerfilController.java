/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.Controller;

import com.portfolio.portfolio.Model.Perfil;
import com.portfolio.portfolio.Security.Controller.Mensaje;
import com.portfolio.portfolio.Service.iPerfilService;
import com.portfolio.portfolio.dto.dtoPerfil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Analia
 */
 
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PerfilController {

    @Autowired
    iPerfilService perfilService;

    @GetMapping("/perfil/lista")
    public ResponseEntity<List<Perfil>> list() {
        List<Perfil> list = perfilService.getPerfils();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/perfil/create")
    public ResponseEntity<?> create(@RequestBody dtoPerfil dtpPerf) {
        if (StringUtils.isEmpty(dtpPerf.getNombres())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (perfilService.existsByNombre(dtpPerf.getNombres())) {
            return new ResponseEntity(new Mensaje("La perfil Existe"), HttpStatus.BAD_REQUEST);
        }
   
        Perfil perfil = new Perfil(dtpPerf.getNombres()
                ,dtpPerf.getApellido(), dtpPerf.getFecha_nacimiento(), dtpPerf.getNacionalidad(),
                dtpPerf.getMail(), dtpPerf.getSobreMi(), dtpPerf.getOcupacion(), dtpPerf.getImage_background_header()
                , dtpPerf.getImage_perfil(), dtpPerf.getDomicilio(), dtpPerf.getLinkedin(), dtpPerf.getGithub(), dtpPerf.getTelefono()
                ,  dtpPerf.getDni());

        perfilService.savePerfil(perfil);
        return new ResponseEntity(new Mensaje("Perfil Agregada"), HttpStatus.OK);
    }

    @GetMapping("/perfil/detail/{id}")
    public ResponseEntity<Perfil> getById(@PathVariable("id") int id) {
        if (!perfilService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Perfil perfil = perfilService.getOne(id).get();
        return new ResponseEntity(perfil, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/perfil/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPerfil dtpPerf) {

        if (!perfilService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id No existe"), HttpStatus.BAD_REQUEST);
        }

        if (perfilService.existsByNombre(dtpPerf.getNombres()) && perfilService.getByNombre(dtpPerf.getNombres()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El perfil ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isEmpty(dtpPerf.getNombres())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Perfil perfil = perfilService.getOne(id).get();
        perfil.setNombres(dtpPerf.getNombres());
        

        perfil.setApellido(dtpPerf.getApellido());
        perfil.setFecha_nacimiento(dtpPerf.getFecha_nacimiento());
        perfil.setNacionalidad(dtpPerf.getNacionalidad());
        perfil.setMail(dtpPerf.getMail());
        perfil.setSobreMi( dtpPerf.getSobreMi());
        perfil.setOcupacion( dtpPerf.getOcupacion());
        perfil.setImage_background_header(dtpPerf.getImage_background_header());
        perfil.setImage_perfil(dtpPerf.getImage_perfil());
        perfil.setDomicilio(dtpPerf.getDomicilio());
        perfil.setLinkedin(perfil.getLinkedin()) ;
        perfil.setTelefono(perfil.getTelefono());
        perfil.setGithub(perfil.getGithub());
        perfil.setDni(perfil.getDni());

        perfilService.savePerfil(perfil);
        return new ResponseEntity(new Mensaje("Perfil Guardada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/perfil/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!perfilService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se encuentra el Id"), HttpStatus.NOT_FOUND);
        }
        perfilService.deletePerfil(id);
        return new ResponseEntity(new Mensaje("Perfil Borrada"), HttpStatus.OK);
    }

}
