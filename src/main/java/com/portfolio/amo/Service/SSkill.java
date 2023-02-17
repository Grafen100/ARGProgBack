package com.portfolio.amo.Service;

import com.portfolio.amo.Entity.Skill;
import com.portfolio.amo.Interface.ISkill;
import com.portfolio.amo.Repository.RSkill;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Grafen Whor
 */
@Service
@Transactional
public class SSkill implements ISkill {
    
 @Autowired
    public RSkill rSkill;

    @Override
    public Skill createSkill(Skill skill) {
        return rSkill.save(skill);
    }
    
    @Override
    public void deleteSkill(int id) {
        rSkill.deleteById(id);
    }

 @Override
    public void saveSkill(Skill skill) {
        rSkill.save(skill);
    }

    @Override
    public Skill findSkill(int id) {
        return rSkill.findById(id).orElse(null);
    }

 @Override
    public List<Skill> getSkill() {
        return rSkill.findAll();
    }

    
}
