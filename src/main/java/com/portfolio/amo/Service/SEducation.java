package com.portfolio.amo.Service;

import com.portfolio.amo.Entity.Education;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.amo.Repository.REducation;

/**
 *
 * @author Grafen Whor
 */
@Service
@Transactional
public class SEducation {
    @Autowired
    REducation rEducation ;
    
    public List<Education> list(){
        return rEducation.findAll();
    }
    
    public Optional <Education> getOne(int id){
        return rEducation.findById(id);
    }
    
    public Optional <Education> getByNombreEduc(String nombreEduc){
        return rEducation.findByNombreEduc(nombreEduc);
    }
    
    public void save(Education educat){
        rEducation.save(educat);
    }
    
    public void delete(int id){
        rEducation.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducation.existsById(id);
    }
    
    public boolean existsByNombreEduc(String nombreEduc){
        return rEducation.existsByNombreEduc(nombreEduc);
    }
}
