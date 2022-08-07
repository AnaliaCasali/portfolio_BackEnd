/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.Controller;

import com.portfolio.portfolio.Model.Persona;
import com.portfolio.portfolio.Service.iPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Analia
 */
@RestController
public class PersonaController {
    @Autowired iPersonaService iPersoServ;
   
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
    return this.iPersoServ.getPersona();
    }

    @PostMapping("personas/crear")  
    public String createPersona(@RequestBody Persona pers){
        iPersoServ.savePersona(pers);
        return "La persona se creo correctamente";

    }
    
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> getPersonas(){
      return iPersoServ.getPersona();
    }    
    @DeleteMapping("/delete/{id}")   
    public String deletePersona(@PathVariable Long id){
      iPersoServ.deletePersona(id);
      return "La persona se elimino correctamente";
    }
    
    @PutMapping("/edit/persona/{id}")   
    public void editPersona(@PathVariable Long id,
                            @RequestParam String newNombre,
                            @RequestParam String newApellido,
                            @RequestParam String newImg,
                            @RequestParam String newDni,
                            @RequestParam String newTelefono
            ){
        Persona persona=this.iPersoServ.findPersona(id);
        persona.setApellido(newApellido);
        persona.setDni(newDni);
        persona.setNombre(newNombre);
        persona.setImg(newImg);
        persona.setTelefono(newTelefono);
        iPersoServ.savePersona(persona);
    }
    
    



//  //List<Persona> listaPersonas= new ArrayList();
    
    // creamos un api
    //metodos para solicitudes http get / post
    /*@GetMapping("/hola")  // indica que ante una solicitud de  GET se ejecuta este metodo, agrego un path opcional
    public String decirHola(){
        return "Hola Mundo";
    }
    
    @GetMapping("/hola/{txt}/{txt1}/{nro}")  
    public String decirHola(@PathVariable String txt,@PathVariable String txt1,@PathVariable int nro){
        return "Hola Mundo " + txt + " "  + txt1 + " " + nro;
    }
    @GetMapping("/chau")      
    public String decirChau(@RequestParam String nombre,
                            @RequestParam String apellido,
                            @RequestParam int edad){
    return "chau mundo " + nombre + " Apellido:" + apellido + " Edad:" + edad ;
    }

    
*/
}