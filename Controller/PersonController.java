package com.portfolio.amo.Controller;

import com.portfolio.amo.Entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.portfolio.amo.Service.SPerson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping ("/person")
@CrossOrigin(origins = {"https://projectam0.netlify.app","http://localhost:4200"})
public class PersonController {
    @Autowired 
     SPerson sPerson;
    
    @GetMapping("/list")
    public ResponseEntity<List<Person>> list() {
        List<Person> list = sPerson.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/fetch/profile")
    public Person findPerson(){
        return sPerson.findPerson((int)1);
    }
    
   /* PARTE DEL CRUD QUE NO SE IMPLEMENTA EN LA APP. PORQUE CONSIDERA UNA SOLA PERSONA.
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/person/create")
    public String createPerson(@RequestBody Person person){
        iPerson.savePerson(person);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable Integer id){
        iPerson.deletePerson(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/person/update/{id}")
    public Person editPerson(@PathVariable Integer id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("imagen") String nuevoImagen){
        Person person = iPerson.findPerson(id);
        
        person.setNombre(nuevoNombre);
        person.setApellido(nuevoApellido);
        person.setImagen(nuevoImagen);
        
        iPerson.savePerson(person);
        return person;
    }
    */
}

