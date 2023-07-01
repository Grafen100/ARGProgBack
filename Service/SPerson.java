package com.portfolio.amo.Service;

import com.portfolio.amo.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.amo.Repository.RPerson;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class SPerson {

    @Autowired
    RPerson rPerson;

    public List<Person> list(){
        return rPerson.findAll();
    }
    
    public Optional <Person> getOne(int id){
        return rPerson.findById(id);
    }
    
    public Optional <Person> getByNombre(String nombre){
        return rPerson.findByNombre(nombre);
    }
    
    public void save(Person person){
        rPerson.save(person);
    }
    
    public void delete(int id){
        rPerson.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPerson.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rPerson.existsByNombre(nombre);
    }
}
