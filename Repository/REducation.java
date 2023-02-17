package com.portfolio.amo.Repository;

import com.portfolio.amo.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Grafen Whor
 */
@Repository
public interface REducation extends JpaRepository<Education, Integer>{
    public Optional<Education> findByNombreEduc(String nombreEduc);
    public boolean existsByNombreEduc(String nombreEduc);
}
