package com.portfolio.amo.Interface;

import com.portfolio.amo.Entity.Person;
import java.util.List;

public interface IPerson {
    // Traer una lista de usuarios
    public List<Person> getPerson();

    //Guardar un objeto de tipo usuario
    public void savePerson(Person person);

    //Eliminar un objeto buscado por ID
    public void deletePerson(int id);

    //Buscar un usuario por ID
    public Person findPerson(int id);
}
