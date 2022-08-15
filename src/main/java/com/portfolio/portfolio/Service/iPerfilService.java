/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.Service;
import com.portfolio.portfolio.Model.Perfil;
import com.portfolio.portfolio.Repository.iPerfilRepository;
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
public class iPerfilService {

    @Autowired
    iPerfilRepository rPerfil;

    public List<Perfil> getPerfils() {
        return this.rPerfil.findAll();
    }

    //busco por id     
    public Optional<Perfil> getOne(int id) {
        return this.rPerfil.findById(id);
    }

    public Optional<Perfil> getByNombre(String nombrePerfil) {
        return this.rPerfil.findByNombres(nombrePerfil);
    }

    //guardo cambios 
    public void savePerfil(Perfil exp) {
        this.rPerfil.save(exp);
    }

    //edito 
    public void editPerfil(Perfil exp) {
    }

    //borro 
    public void deletePerfil(Integer id) {
        this.rPerfil.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return this.rPerfil.existsById(id);
    }

    public boolean existsByNombre(String nombrePerfil) {
        return this.rPerfil.existsByNombres(nombrePerfil);
    }
}
