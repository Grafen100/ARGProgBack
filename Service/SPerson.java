package com.portfolio.amo.Service;

import com.portfolio.amo.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.portfolio.amo.Interface.IPerson;
import com.portfolio.amo.Repository.RPerson;

@Service
public  class SPerson implements IPerson {
    
    @Autowired RPerson rPerson;
    
    @Override
    public List<Person> getPerson() {
        List<Person> person = rPerson.findAll();
        return person;
    }

    @Override
    public void savePerson(Person person) {
        rPerson.save(person);
    }

    @Override
    public void deletePerson(int id) {
        rPerson.deleteById(id);
    }

    @Override
    public Person findPerson(int id) {
        Person person = rPerson.findById(id).orElse(null);
        return person;
    }
}
