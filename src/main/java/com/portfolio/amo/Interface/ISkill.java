package com.portfolio.amo.Interface;

import com.portfolio.amo.Entity.Skill;
import java.util.List;

/**
 *
 * @author Grafen Whor
 */
public interface ISkill {
    
    public Skill createSkill (Skill skill);
    public void deleteSkill (int id);
    public void saveSkill (Skill skill);
    public Skill findSkill (int id);
    public List<Skill> getSkill();
}
