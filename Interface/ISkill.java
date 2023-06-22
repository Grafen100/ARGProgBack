package com.portfolio.amo.Interface;

import com.portfolio.amo.Entity.Skill;
import java.util.List;

/**
 *
 * @author Grafen Whor
 */
public interface ISkill {
    
    //Crear una habilidad
    public Skill createSkill (Skill skill);
    
    //Eliminar una habilidad buscada por ID
    public void deleteSkill (int id);
    
    //Guardar una habilidad
    public void saveSkill (Skill skill);
    
    //Buscar una habilidad por ID
    public Skill findSkill (int id);
    
    // Traer una lista de habilidades
    public List<Skill> getSkill();
}
