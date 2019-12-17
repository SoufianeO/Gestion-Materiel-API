package com.ocp.Controller;

import com.ocp.Dao.FontionnaireDao;
import com.ocp.Model.Fonctionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fonctionnaire")
public class FonctionnaireController {

    @Autowired
    FontionnaireDao fontionnaireDao;

    //partie authentification

    @PostMapping("/authenticate")
    public boolean authenticate(@Valid @RequestBody String matricule, String password){
        Fonctionnaire fn = fontionnaireDao.getOne(matricule);
        if(fn.getMatricule()==matricule && fn.getMotPasse()==password){
            return true;
        }
        else return false;
    }

    //partie CRUD


    @GetMapping("/fonctionnaires")
    public List<Fonctionnaire> getAllFonctionnaires(){
        return fontionnaireDao.findAll();
    }

    @PostMapping("/fonctionnaires")
    public Fonctionnaire addFonctionnaire(@Valid @RequestBody Fonctionnaire fonctionnaire){
        return fontionnaireDao.save(fonctionnaire);
    }

    @GetMapping("/fonctionnaires/{id}")
    public Optional<Fonctionnaire> getFonctionnaire(@PathVariable(value = "id") String login){
        return fontionnaireDao.findById(login);
    }

    @DeleteMapping("/fonctionnaires/{id}")
    public void deleteFonctionnaire(@PathVariable(value = "id") String matricule){
        fontionnaireDao.deleteById(matricule);
    }

    @PutMapping(path = "/fonctionnaires/{id}",
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updateFonctionnaire(@PathVariable(value = "id") String id,@Valid @RequestBody Fonctionnaire fonctionnaire1) {

        Fonctionnaire fonctionnaire = fontionnaireDao.getOne(id);
        fonctionnaire.setMatricule(fonctionnaire1.getMatricule());
        fonctionnaire.setEmail(fonctionnaire1.getEmail());
        fonctionnaire.setNom(fonctionnaire1.getNom());
        fonctionnaire.setPrenom(fonctionnaire1.getPrenom());
        fonctionnaire.setService(fonctionnaire1.getService());
        fonctionnaire.setSite(fonctionnaire1.getSite());
        fonctionnaire.setLogin(fonctionnaire1.getLogin());
        fonctionnaire.setMotPasse(fonctionnaire1.getMotPasse());
        fonctionnaire.setRole(fonctionnaire1.getRole());
        fontionnaireDao.save(fonctionnaire);

    }
}
