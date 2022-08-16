/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.Controller;

import com.portfolio.portfolio.Model.Proyecto;
import com.portfolio.portfolio.Security.Controller.Mensaje;
import com.portfolio.portfolio.Service.iProyectoService;
import com.portfolio.portfolio.dto.dtoProyecto;
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
@CrossOrigin(origins = "https://frontendportfolioanalia.web.app")

public class ProyectoController {

    @Autowired
    iProyectoService proyectoService;

    @GetMapping("/proyecto/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = proyectoService.getProyectos();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyecto/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoExp) {
        if (StringUtils.isEmpty(dtoExp.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (proyectoService.existsByNombre(dtoExp.getNombre())) {
            return new ResponseEntity(new Mensaje("La proyecto Existe"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(dtoExp.getNombre(),
                dtoExp.getDescripcion(), dtoExp.getInicio(), dtoExp.getFin());

        proyectoService.saveProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto Agregada"), HttpStatus.OK);
    }

    @GetMapping("/proyecto/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/proyecto/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoExp) {

        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id No existe"), HttpStatus.BAD_REQUEST);
        }

        if (proyectoService.existsByNombre(dtoExp.getNombre()) && proyectoService.getByNombre(dtoExp.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isEmpty(dtoExp.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
 
        Proyecto proyecto = proyectoService.getOne(id).get();
        proyecto.setNombre(dtoExp.getNombre());
        proyecto.setDescripcion(dtoExp.getDescripcion());
        proyecto.setInicio(dtoExp.getInicio());
        proyecto.setFin(dtoExp.getFin());

        proyectoService.saveProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto Guardada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/proyecto/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se encuentra el Id"), HttpStatus.NOT_FOUND);
        }
        proyectoService.deleteProyecto(id);
        return new ResponseEntity(new Mensaje("Proyecto Borrada"), HttpStatus.OK);
    }

}
