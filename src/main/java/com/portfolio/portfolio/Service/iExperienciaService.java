/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Model.Experiencia;
import com.portfolio.portfolio.Repository.iExperienciaRepository;
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
public class iExperienciaService {

    @Autowired
    iExperienciaRepository rExperiencia;

    public List<Experiencia> getExperiencias() {
        return this.rExperiencia.findAll();
    }

    //busco por id     
    public Optional<Experiencia> getOne(int id) {
        return this.rExperiencia.findById(id);
    }

    public Optional<Experiencia> getByNombre(String nombreExperiencia) {
        return this.rExperiencia.findByNombre(nombreExperiencia);
    }

    //guardo cambios 
    public void saveExperiencia(Experiencia exp) {
        this.rExperiencia.save(exp);
    }

    //edito 
    public void editExperiencia(Experiencia exp) {
    }

    //borro 
    public void deleteExperiencia(Integer id) {
        this.rExperiencia.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return this.rExperiencia.existsById(id);
    }

    public boolean existsByNombre(String nombreExperiencia) {
        return this.rExperiencia.existsByNombre(nombreExperiencia);
    }
}
