package com.portfolio.portfolio.Interface;

/**
 *
 * @author Analia
 */
 

import com.portfolio.portfolio.Model.Persona;
import com.portfolio.portfolio.Repository.iPersonaRepository;
import com.portfolio.portfolio.Service.iPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Analia
 */
@Service
public class ImpPersonaService  implements iPersonaService{
    @Autowired
    public iPersonaRepository iPersoRepo;

    
    @Override
    public List<Persona> getPersona() {
        return iPersoRepo.findAll();    
    }

    @Override
    public void savePersona(Persona per) {
        this.iPersoRepo.save(per);
    }

    @Override
    public void editPersona(Persona per) {
        this.iPersoRepo.save(per);
    }

    @Override
    public void deletePersona(Long id) {
        this.iPersoRepo.deleteById(id);
   }

    @Override
    public Persona findPersona(Long id) {
        return iPersoRepo.findById(id).orElse(null);}
  
    
    
}
