package com.portfolio.amo.Repository;

import com.portfolio.amo.Entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Grafen Whor
 */
@Repository
public interface RProject extends JpaRepository<Project, Integer> {

    public Optional<Project> findByNombreProj(String nombreProj);

    public boolean existsByNombreProj(String nombreProj);
}
