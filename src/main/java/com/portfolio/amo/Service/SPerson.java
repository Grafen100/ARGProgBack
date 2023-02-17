package com.portfolio.amo.Service;

import com.portfolio.amo.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.portfolio.amo.Repository.RPerson;
import java.util.Optional;
import javax.transaction.Transactional;

/**
 *
 * @author Grafen Whor
 */

@Service
@Transactional
public class SPerson {

    @Autowired
    RPerson rPerson;

    public List<Person> getPerson() {
        List<Person> person = rPerson.findAll();
        return person;
    }

    public void delete(int id) {
        rPerson.deleteById(id);
    }

    
    public Person findPerson(int id) {
        Person person = rPerson.findById(id).orElse(null);
        return person;
    }

    public boolean existsById(int id) {
        return rPerson.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return rPerson.existsByNombre(nombre);
    }

    public void save(Person person) {
        rPerson.save(person);
    }

    public Optional<Person> getByNombre(String nombre) {
        return rPerson.findByNombre(nombre);
    }

    public Optional <Person> getOne(int id){
        return rPerson.findById(id);
    }

    public List<Person> list(){
        return rPerson.findAll();
    }
    
}
