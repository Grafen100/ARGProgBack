package com.portfolio.amo.Controller;

import com.portfolio.amo.Dto.EducationDto;
import com.portfolio.amo.Entity.Education;
import com.portfolio.amo.Security.Controller.Mensaje;
import com.portfolio.amo.Service.SEducation;
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
@RequestMapping("/educat")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EducationController {
    @Autowired
    SEducation sEducation;
    
    @GetMapping("/list")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = sEducation.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id) {
        if (!sEducation.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Education education = sEducation.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducation.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sEducation.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducationDto educDto) {
        if (StringUtils.isBlank(educDto.getNombreEduc())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sEducation.existsByNombreEduc(educDto.getNombreEduc())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }

        Education education = new Education(educDto.getNombreEduc(),
                educDto.getFechaInicio(), educDto.getFechaFinal(), educDto.getDescEduc());
        sEducation.save(education);

        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducationDto educDto) {
        //Valida si existe el ID
        if (!sEducation.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de educaciones
        if (sEducation.existsByNombreEduc(educDto.getNombreEduc())
                && sEducation.getByNombreEduc(educDto.getNombreEduc()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(educDto.getNombreEduc())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Education educat = sEducation.getOne(id).get();
        educat.setNombreEduc(educDto.getNombreEduc());
        educat.setFechaInicio(educDto.getFechaInicio());
        educat.setFechaFinal(educDto.getFechaFinal());
        educat.setDescEduc(educDto.getDescEduc());

        sEducation.save(educat);
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);

    }
}
