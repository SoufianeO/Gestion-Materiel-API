package com.ocp.Controller;

import com.ocp.Dao.FournisseurDao;
import com.ocp.Model.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
    @Autowired
    FournisseurDao fournisseurDao;
    @GetMapping("/fournisseurs")
    public List<Fournisseur> getAllFournisseurs(){
        return fournisseurDao.findAll();
    }

    @PostMapping("/fournisseurs")
    public Fournisseur addFournisseur(@Valid @RequestBody Fournisseur fournisseur){
        return fournisseurDao.save(fournisseur);
    }

    @GetMapping("/fournisseurs/{id}")
    public Optional<Fournisseur> getFournisseur(@PathVariable(value = "id") String id){
        return fournisseurDao.findById(id);
    }

    @DeleteMapping("/fournisseurs/{id}")
    public void deleteFournisseur(@PathVariable(value = "id") String id){
        fournisseurDao.deleteById(id);
    }

    @PutMapping(path = "/fournisseurs/{id}",
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updateFournisseur(@PathVariable(value = "id") String id, @Valid @RequestBody Fournisseur fournisseur1) {

        Fournisseur fournisseur = fournisseurDao.getOne(id);
        fournisseur.setRepresentant(fournisseur1.getRepresentant());
        fournisseur.setEmail(fournisseur1.getEmail());
        fournisseur.setNom(fournisseur1.getNom());
        fournisseur.setPrenom(fournisseur1.getPrenom());
        fournisseur.setTel(fournisseur1.getTel());
        fournisseurDao.save(fournisseur);

    }
}
