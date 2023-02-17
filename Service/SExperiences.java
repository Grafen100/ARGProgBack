package com.portfolio.amo.Service;

import com.portfolio.amo.Entity.Experiences;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.amo.Repository.RExperiences;

/**
 *
 * @author Grafen Whor
 */
@Service
@Transactional
public class SExperiences {
    @Autowired
    RExperiences  rExperiences;
    
    public List<Experiences> list(){
        return rExperiences.findAll();
    }
    
    public Optional <Experiences> getOne(int id){
        return rExperiences.findById(id);
    }
    
    public Optional <Experiences> getByNombreExp(String nombreExp){
        return rExperiences.findByNombreExp(nombreExp);
    }
    
    public void save(Experiences expe){
        rExperiences.save(expe);
    }
    
    public void delete(int id){
        rExperiences.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExperiences.existsById(id);
    }
    
    public boolean existsByNombreExp(String nombreExp){
        return rExperiences.existsByNombreExp(nombreExp);
    }
}
