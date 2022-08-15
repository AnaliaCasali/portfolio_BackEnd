/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.Security.Service;

import com.portfolio.portfolio.Security.Enums.Entity.Rol;
import com.portfolio.portfolio.Security.Enums.RolNombre;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.portfolio.Security.Repository.iRolRepository;
import java.util.Optional;
/**
 *
 * @author Analia
 */
@Service
@Transactional  //define la persistencia-- hace roolback si la operacion falla
public class RolService {
@Autowired
iRolRepository irolRepository;
public Optional<Rol> getByRolNombre(RolNombre rolnombre){
   return  irolRepository.findByRolNombre(rolnombre);
}
public void save(Rol rol){
irolRepository.save(rol);
}
}
