package com.portfolio.amo.Service;

import com.portfolio.amo.Entity.Project;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.amo.Repository.RProject;


/**
 *
 * @author Grafen Whor
 */
@Service
@Transactional
public class SProject {
     @Autowired
    RProject  rProject;
    
    public List<Project> list(){
        return rProject.findAll();
    }
    
    public Optional <Project> getOne(int id){
        return rProject.findById(id);
    }
    
    public Optional <Project> getByNombreProj(String nombreProj){
        return rProject.findByNombreProj(nombreProj);
    }
    
    public void save(Project proj){
        rProject.save(proj);
    }
    
    public void delete(int id){
        rProject.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProject.existsById(id);
    }
    
    public boolean existsByNombreProj(String nombreProj){
        return rProject.existsByNombreProj(nombreProj);
    }
    
}
