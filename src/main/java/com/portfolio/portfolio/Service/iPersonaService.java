
package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Model.Persona;
import java.util.List;
/**
 *
 * @author Analia
 */
public interface iPersonaService {

    public List<Persona> getPersona();

    //guardo cambios nuec
    public void savePersona(Persona per);

    //edito persona
    public void editPersona(Persona per);

    //borro persona
    public void deletePersona(Long id);

    //busco persona por id
    public Persona findPersona(Long id);

}
