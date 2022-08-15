/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.Repository;

import com.portfolio.portfolio.Model.Perfil;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Analia
 */
@Repository
public interface iPerfilRepository extends JpaRepository<Perfil, Integer>
{
    public Optional<Perfil> findByNombres(String nombre);  
    public boolean existsByNombres(String nombre);
}

