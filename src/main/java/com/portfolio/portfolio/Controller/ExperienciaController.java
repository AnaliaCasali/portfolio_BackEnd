/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.Controller;

import com.portfolio.portfolio.Model.Experiencia;
import com.portfolio.portfolio.Security.Controller.Mensaje;
import com.portfolio.portfolio.Service.iExperienciaService;
import com.portfolio.portfolio.dto.dtoExperiencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Analia
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ExperienciaController {

    @Autowired
    iExperienciaService experienciaService;

    @GetMapping("/experiencia/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = experienciaService.getExperiencias();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experiencia/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp) {
        if (StringUtils.isEmpty(dtoExp.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (experienciaService.existsByNombre(dtoExp.getNombre())) {
            return new ResponseEntity(new Mensaje("La experiencia Existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoExp.getNombre(),
                dtoExp.getPuesto(), dtoExp.getImagen(), dtoExp.getDescripcion(), dtoExp.getInicio(), dtoExp.getFin());

        experienciaService.saveExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);
    }

    @GetMapping("/experiencia/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/experiencia/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoExp) {

        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id No existe"), HttpStatus.BAD_REQUEST);
        }

        if (experienciaService.existsByNombre(dtoExp.getNombre()) && experienciaService.getByNombre(dtoExp.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isEmpty(dtoExp.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isEmpty(dtoExp.getPuesto())) {
            return new ResponseEntity(new Mensaje("El puesto es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setNombre(dtoExp.getNombre());
        experiencia.setPuesto(dtoExp.getPuesto());
        experiencia.setImagen(dtoExp.getImagen());
        experiencia.setDescripcion(dtoExp.getDescripcion());
        experiencia.setInicio(dtoExp.getInicio());
        experiencia.setFin(dtoExp.getFin());

        experienciaService.saveExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Guardada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/experiencia/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se encuentra el Id"), HttpStatus.NOT_FOUND);
        }
        experienciaService.deleteExperiencia(id);
        return new ResponseEntity(new Mensaje("Experiencia Borrada"), HttpStatus.OK);
    }

}
