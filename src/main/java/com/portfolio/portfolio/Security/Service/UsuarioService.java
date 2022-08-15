/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.Security.Service;

import com.portfolio.portfolio.Security.Enums.Entity.Usuario;
import com.portfolio.portfolio.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Analia
 */
@Service
@Transactional  //define la persistencia-- hace roolback si la operacion falla
 
public class UsuarioService {
 @Autowired   
 iUsuarioRepository iusuarioRepository ;
 public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
 return iusuarioRepository.findByNombreUsuario(nombreUsuario);}
 
 public boolean existsByNombreUsuario(String nomUsuario){
     return iusuarioRepository.existsByNombreUsuario(nomUsuario);}


 public boolean existsByEmail(String email){
    return iusuarioRepository.existsByEmail(email);}

public void save(Usuario usuario)
{
 iusuarioRepository.save(usuario);
         }
}