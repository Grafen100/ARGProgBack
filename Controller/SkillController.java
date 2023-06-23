package com.portfolio.amo.Controller;

import com.portfolio.amo.Entity.Skill;
import com.portfolio.amo.Interface.ISkill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Grafen Whor
 */
@RestController
@RequestMapping("/sh&ss")
@CrossOrigin(origins = { "https://projectam0.netlify.app" ,"http://localhost:4200"})
public class SkillController {

    @Autowired
    private ISkill iSkill;

    
    @PostMapping("/create")
    public Skill createSkill(@RequestBody Skill skill) {
        return iSkill.createSkill(skill);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSkill(@PathVariable Integer id) {
        iSkill.deleteSkill(id);
    }

    @PutMapping("/update")
    public Skill updateSkill(@RequestBody Skill skill){
        
        iSkill.saveSkill(skill);
        return skill;
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public Skill findSkill(@PathVariable int id) {
        return iSkill.findSkill(id);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Skill> list() {
        return iSkill.getSkill();
    }

}
