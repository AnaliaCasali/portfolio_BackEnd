/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.Repository;
import com.portfolio.portfolio.Model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Analia
 */
@Repository
public interface iExperienciaRepository extends JpaRepository<Experiencia, Integer>
{
    public Optional<Experiencia> findByNombre(String nombreExperiencia);  
    public boolean existsByNombre(String nombreExperiencia);
}
