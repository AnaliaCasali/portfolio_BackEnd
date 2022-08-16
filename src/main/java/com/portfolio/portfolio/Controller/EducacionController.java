/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.Controller;

import com.portfolio.portfolio.Model.Educacion;
import com.portfolio.portfolio.Security.Controller.Mensaje;
import com.portfolio.portfolio.Service.iEducacionService;
import com.portfolio.portfolio.dto.dtoEducacion;
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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Analia
 */
@RestController
@CrossOrigin(origins = "https://frontendportfolioanalia.web.app")

public class EducacionController {

    @Autowired
    iEducacionService educacionService;

    @GetMapping("/educacion/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = educacionService.getEducacion();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/educacion/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEduc) {
        if (StringUtils.isEmpty(dtoEduc.getTitulo())) {
            return new ResponseEntity(new Mensaje("El titulo es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (educacionService.existsByTitulo(dtoEduc.getTitulo())) {
            return new ResponseEntity(new Mensaje("La educacion Existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoEduc.getEscuela(),
                dtoEduc.getTitulo(), dtoEduc.getImagen(), dtoEduc.getCarrera(), dtoEduc.getPuntaje(), dtoEduc.getInicio(), dtoEduc.getFin());

        educacionService.saveEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion Agregada"), HttpStatus.OK);
    }

    @GetMapping("/educacion/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/educacion/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoEduc) {

        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id No existe"), HttpStatus.BAD_REQUEST);
        }

        if (educacionService.existsByTitulo(dtoEduc.getTitulo()) && educacionService.getByTitulo(dtoEduc.getTitulo()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La educacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isEmpty(dtoEduc.getTitulo())) {
            return new ResponseEntity(new Mensaje("El titulo es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = educacionService.getOne(id).get();
        educacion.setEscuela(dtoEduc.getEscuela());
        educacion.setTitulo(dtoEduc.getTitulo());
        educacion.setImagen(dtoEduc.getImagen());
        educacion.setCarrera(dtoEduc.getCarrera());
        educacion.setPuntaje(dtoEduc.getPuntaje());
        educacion.setInicio(dtoEduc.getInicio());
        educacion.setFin(dtoEduc.getFin());

        educacionService.saveEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion Guardada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/educacion/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se encuentra el Id"), HttpStatus.NOT_FOUND);
        }
        educacionService.deleteEducacion(id);
        return new ResponseEntity(new Mensaje("Educacion Borrada"), HttpStatus.OK);
    }

}
