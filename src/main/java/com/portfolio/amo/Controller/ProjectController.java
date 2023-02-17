package com.portfolio.amo.Controller;

import com.portfolio.amo.Dto.ProjectDto;
import com.portfolio.amo.Entity.Project;
import com.portfolio.amo.Security.Controller.Mensaje;
import com.portfolio.amo.Service.SProject;
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
@RequestMapping("/proje")
@CrossOrigin(origins = {"http://localhost:4200","https://projectam0-app.web.app"})
public class ProjectController {

     @Autowired
    SProject sProject;

    
    @GetMapping("/list")
    public ResponseEntity<List<Project>> list() {
        List<Project> list = sProject.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") int id) {
        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Project project = sProject.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sProject.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProjectDto projDto) {
        if (StringUtils.isBlank(projDto.getNombreProj())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProject.existsByNombreProj(projDto.getNombreProj())) {
            return new ResponseEntity(new Mensaje("Ese proyecto existe"), HttpStatus.BAD_REQUEST);
        }

        Project project = new Project(projDto.getNombreProj(),
                projDto.getDescProj(), projDto.getImagenProj());
       sProject.save(project);

        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProjectDto projDto) {
        //Valida si existe el ID
        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de proyectos
        if (sProject.existsByNombreProj(projDto.getNombreProj())
                && sProject.getByNombreProj(projDto.getNombreProj()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(projDto.getNombreProj())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Project project = sProject.getOne(id).get();
        project.setNombreProj(projDto.getNombreProj());
        project.setDescProj(projDto.getDescProj());
        project.setImagenProj(projDto.getImagenProj());

        sProject.save(project);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);

    }
}

