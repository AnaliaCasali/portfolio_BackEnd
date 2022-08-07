package com.portfolio.portfolio.Model;



import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Analia
 */
@Setter @Getter
@Entity
public class Persona {
    
     //mapeo
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;
    @Basic
    private String dni;
    @NotNull
    @Size(min=1,max= 50, message="No cumple con la longitud")
    private String apellido;
    @NotNull
    @Size(min=1,max= 50, message="No cumple con la longitud")
    private String nombre;
 
    private String telefono;
    
    @Size(min=1,max= 50, message="No cumple con la longitud")
    private String img;

    public Persona(){}

    public Persona(long id, String dni, String apellido, String nombre, String telefono, String img) {
        this.id = id;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.img=img;
    }
}
