package com.ocp.Controller;
import com.ocp.Dao.UtilisateurDao;
import com.ocp.Model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
        @Autowired
        UtilisateurDao utilisateurDao;
        @GetMapping("/utilisateurs")
        public List<Utilisateur> getAllUtilisateurs(){
            return utilisateurDao.findAll();
        }

        @PostMapping("/utilisateurs")
        public Utilisateur addFournisseur(@Valid @RequestBody Utilisateur utilisateur){
            return utilisateurDao.save(utilisateur);
        }

        @GetMapping("/utilisateurs/{id}")
        public Optional<Utilisateur> getUtilisateur(@PathVariable(value = "id") String id){
            return utilisateurDao.findById(id);
        }

        @DeleteMapping("/utilisateurs/{id}")
        public void deleteUtilisateur(@PathVariable(value = "id") String id){
            utilisateurDao.deleteById(id);
        }

    @PutMapping(path = "/utilisateurs/{id}",
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updateUtilisateur(@PathVariable(value = "id") String id,@Valid @RequestBody Utilisateur utilisateur1) {

        Utilisateur utilisateur = utilisateurDao.getOne(id);
        utilisateur.setMatricule(utilisateur1.getMatricule());
        utilisateur.setEmail(utilisateur1.getEmail());
        utilisateur.setNom(utilisateur1.getNom());
        utilisateur.setPrenom(utilisateur1.getPrenom());
        utilisateur.setService(utilisateur1.getService());
        utilisateur.setSite(utilisateur1.getSite());
        utilisateurDao.save(utilisateur);

    }
}