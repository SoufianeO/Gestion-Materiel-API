package com.ocp.Controller;

import com.ocp.Dao.ContratDao;
import com.ocp.Model.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    ContratDao contratDao;

    @GetMapping("/contrats")
    public List<Contrat> getAllContrats(){
        return contratDao.findAll();
    }

    @PostMapping("/contrats")
    public Contrat addContrat(@Valid @RequestBody Contrat contrat){
        return contratDao.save(contrat);
    }

    @GetMapping("/contrats/{id}")
    public Optional<Contrat> getContrat(@PathVariable(value = "id") String matricule){
        return contratDao.findById(matricule);
    }

    @DeleteMapping("/contrats/{id}")
    public void deleteContrat(@PathVariable String matricule){
        contratDao.deleteById(matricule);
    }

    @PutMapping(path = "/contrats/{id}",
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updateContrat(@PathVariable(value = "id") String id, @Valid @RequestBody Contrat contrat1) {

        Contrat contrat = contratDao.getOne(id);
        contrat.setDateAcquisition(contrat1.getDateAcquisition());
        contrat.setDelaiReponse(contrat1.getDelaiReponse());
        contrat.setDelaiResolution(contrat1.getDelaiResolution());
        contrat.setDureeGarantie(contrat1.getDureeGarantie());
        contratDao.save(contrat);

    }
}
