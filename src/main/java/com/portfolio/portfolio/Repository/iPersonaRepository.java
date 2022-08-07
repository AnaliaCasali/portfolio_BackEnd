
package com.portfolio.portfolio.Repository;
import com.portfolio.portfolio.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Analia
 */
@Repository
public interface iPersonaRepository  extends JpaRepository<Persona, Long>{
    
}
