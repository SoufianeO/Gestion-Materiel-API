package com.ocp.Controller;

import com.ocp.Dao.MaterielDao;
import com.ocp.Model.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/materiel")
public class MaterielController {

    @Autowired
    MaterielDao materielDao;

    @GetMapping("/materiels")
    public List<Materiel> getAllMateriels(){
        return materielDao.findAll();
    }

    @PostMapping("/materiels")
    public Materiel addMateriel(@Valid @RequestBody Materiel materiel){
        return materielDao.save(materiel);
    }

    @GetMapping("/materiels/{id}")
    public Optional<Materiel> getMateriel(@PathVariable(value = "id") String id){
        return materielDao.findById(id);
    }

    @DeleteMapping("/materiels/{id}")
    public void deleteMateriel(@PathVariable(value = "id") String id){
        materielDao.deleteById(id);
    }

    @PutMapping(path = "/materiels/{id}",
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updateMateriel(@PathVariable(value = "id") String id,@Valid @RequestBody Materiel materiel1) {

        Materiel materiel = materielDao.getOne(id);
        materiel.setEtat(materiel1.getEtat());
        materiel.setDateAcquisition(materiel1.getDateAcquisition());
        materiel.setDateMettreEnService(materiel1.getDateMettreEnService());
        materiel.setMarque(materiel1.getMarque());
        materiel.setModel(materiel1.getModel());
        materiel.setType(materiel1.getType());
        materielDao.save(materiel);

    }

}
