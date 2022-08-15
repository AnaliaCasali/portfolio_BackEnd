/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Model.Proyecto;
import com.portfolio.portfolio.Repository.iProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Analia
 */

@Service
@Transactional
public class iProyectoService {

    @Autowired
    iProyectoRepository rProyecto;

    public List<Proyecto> getProyectos() {
        return this.rProyecto.findAll();
    }

    //busco por id     
    public Optional<Proyecto> getOne(int id) {
        return this.rProyecto.findById(id);
    }

    public Optional<Proyecto> getByNombre(String nombreProyecto) {
        return this.rProyecto.findByNombre(nombreProyecto);
    }

    //guardo cambios 
    public void saveProyecto(Proyecto exp) {
        this.rProyecto.save(exp);
    }

    //edito 
    public void editProyecto(Proyecto exp) {
    }

    //borro 
    public void deleteProyecto(Integer id) {
        this.rProyecto.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return this.rProyecto.existsById(id);
    }

    public boolean existsByNombre(String nombreProyecto) {
        return this.rProyecto.existsByNombre(nombreProyecto);
    }
}
