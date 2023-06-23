package com.portfolio.amo.Controller;

import com.portfolio.amo.Dto.ExperiencesDto;
import com.portfolio.amo.Entity.Experiences;
import com.portfolio.amo.Security.Controller.Mensaje;
import com.portfolio.amo.Service.SExperiences;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Grafen Whor
 */
@RestController
@RequestMapping("/expjob")
@CrossOrigin(origins = {"https://projectAm0.netlify.app","http://localhost:4200"})
public class ExperiencesController {

    @Autowired
    SExperiences sExperiences;

    
    @GetMapping("/list")
    public ResponseEntity<List<Experiences>> list() {
        List<Experiences> list = sExperiences.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiences> getById(@PathVariable("id") int id) {
        if (!sExperiences.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Experiences experiences = sExperiences.getOne(id).get();
        return new ResponseEntity(experiences, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiences.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sExperiences.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperiencesDto expDto) {
        if (StringUtils.isBlank(expDto.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sExperiences.existsByNombreExp(expDto.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }

        Experiences experiences = new Experiences(expDto.getNombreExp(),
                expDto.getFechaInicio(), expDto.getFechaFinal(), expDto.getDescExp());
        sExperiences.save(experiences);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperiencesDto expDto) {
        //Valida si existe el ID
        if (!sExperiences.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de experiencias
        if (sExperiences.existsByNombreExp(expDto.getNombreExp())
                && sExperiences.getByNombreExp(expDto.getNombreExp()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(expDto.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiences experiences = sExperiences.getOne(id).get();
        experiences.setNombreExp(expDto.getNombreExp());
        experiences.setFechaInicio(expDto.getFechaInicio());
        experiences.setFechaFinal(expDto.getFechaFinal());
        experiences.setDescExp(expDto.getDescExp());

        sExperiences.save(experiences);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }
}
