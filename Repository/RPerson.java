package com.portfolio.amo.Repository;

import com.portfolio.amo.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Grafen Whor
 */
@Repository
public interface RPerson extends JpaRepository <Person,Integer>{

}
