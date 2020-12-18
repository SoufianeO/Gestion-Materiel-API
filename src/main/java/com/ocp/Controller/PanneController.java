package com.ocp.Controller;

import com.ocp.Dao.PanneDao;
import com.ocp.Model.Panne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/panne")
public class PanneController {
    @Autowired
    PanneDao panneDao;

    @GetMapping("/pannes")
    public List<Panne> getAllPannes(){
        return panneDao.findAll();
    }

    @GetMapping("/pannes/{id}")
    public Optional<Panne> getPanne(@PathVariable(value = "id") String numeroDemande){
        return panneDao.findById(numeroDemande);
    }

    @PostMapping("/pannes")
    public Panne addPanne(@Valid @RequestBody Panne panne){
        return panneDao.save(panne);
    }


    @DeleteMapping("/pannes/{id}")
    public void deletePanne(@PathVariable String numeroDemande){
        panneDao.deleteById(numeroDemande);
    }

    @PutMapping(path = "/pannes/{id}",
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updatePanne(@PathVariable(value = "id") String id,@Valid @RequestBody Panne panne1) {

        Panne panne = panneDao.getOne(id);
        panne.setDateDeclaration(panne1.getDateDeclaration());
        panne.setDelaiResolution(panne1.getDelaiResolution());
        panne.setDescription(panne1.getDescription());
        panne.setEtat(panne1.getEtat());
        panneDao.save(panne);

    }

}
