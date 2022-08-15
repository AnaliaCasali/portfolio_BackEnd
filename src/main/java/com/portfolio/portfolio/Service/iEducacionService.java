/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.Service;
import com.portfolio.portfolio.Model.Educacion;
import com.portfolio.portfolio.Repository.iEducacionRepository;
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
public class iEducacionService {

    @Autowired
    iEducacionRepository rEducacion;


        public List<Educacion> getEducacion() {
        return this.rEducacion.findAll();
    }

    //busco por id     
    public Optional<Educacion> getOne(int id) {
        return this.rEducacion.findById(id);
    }

    public Optional<Educacion> getByTitulo(String titulo) {
        return this.rEducacion.findByTitulo(titulo);
    }

    //guardo cambios 
    public void saveEducacion(Educacion exp) {
        this.rEducacion.save(exp);
    }

    //edito 
    public void editEducacion(Educacion exp) {
    }

    //borro 
    public void deleteEducacion(Integer id) {
        this.rEducacion.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return this.rEducacion.existsById(id);
    }

    public boolean existsByTitulo(String titulo) {
        return this.rEducacion.existsByTitulo(titulo);
    }
    
}
