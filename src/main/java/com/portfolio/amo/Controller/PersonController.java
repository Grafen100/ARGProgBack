package com.portfolio.amo.Controller;

import com.portfolio.amo.Dto.PersonDto;
import com.portfolio.amo.Entity.Person;
import com.portfolio.amo.Entity.Project;
import com.portfolio.amo.Security.Controller.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.portfolio.amo.Service.SPerson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping ("/person")
@CrossOrigin(origins = {"http://localhost:4200","https://projectam0.netlify.app"})


public class PersonController {
   
     @Autowired
    SPerson sPerson;

    
    @GetMapping("/list")
    public ResponseEntity<List<Person>> list() {
        List<Person> list = sPerson.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") int id) {
        if (!sPerson.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Person person = sPerson.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }
/*  *******************************************************************************************
    *** LINEAS COMENTADAS PORQUE EN ESTA APP NO SE CREARA OTRA PERSONA Y TAMPOCO SE BORRARÁ ***
    *******************************************************************************************
    
    */
    /*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sPerson.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sPerson.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonDto persDto) {
        if (StringUtils.isBlank(persDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sPerson.existsByNombre(persDto.getNombre())) {
            return new ResponseEntity(new Mensaje("Ese persona ya existe"), HttpStatus.BAD_REQUEST);
        }

        Person person = new Person(persDto.getNombre(),persDto.getApellido(),
                persDto.getDescPers(), persDto.getImagen(), persDto.getTelefono());
       sPerson.save(person);

        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
*/

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PersonDto persDto) {
        //Valida si existe el ID
        if (!sPerson.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de la persona
        if (sPerson.existsByNombre(persDto.getNombre())
                && sPerson.getByNombre(persDto.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esta persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(persDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Person person = sPerson.getOne(id).get();
        person.setNombre(persDto.getNombre());
        person.setApellido(persDto.getApellido());
        person.setDescPers(persDto.getDescPers());
        person.setImagen(persDto.getImagen());

        sPerson.save(person);
        return new ResponseEntity(new Mensaje("Datos de persona actualizada"), HttpStatus.OK);

    }
}

