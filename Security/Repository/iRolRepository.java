package com.portfolio.amo.Security.Repository;

import com.portfolio.amo.Security.Entity.Rol;
import com.portfolio.amo.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Grafen Whor
 */
@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
