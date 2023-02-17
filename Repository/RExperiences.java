package com.portfolio.amo.Repository;

import com.portfolio.amo.Entity.Experiences;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Grafen Whor
 */
@Repository
public interface RExperiences extends JpaRepository<Experiences, Integer>{
    public Optional<Experiences> findByNombreExp(String nombreExp);
    public boolean existsByNombreExp(String nombreExp);
    
}
