package com.portfolio.amo.Repository;

import com.portfolio.amo.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Grafen Whor
 */

@Repository
public interface RSkill extends JpaRepository <Skill,Integer>{
    
}
