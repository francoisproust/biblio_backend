package com.bibliotheque.controleur;

import com.bibliotheque.modele.dao.ExemplaireDao;
import com.bibliotheque.modele.entities.Exemplaire;
import com.bibliotheque.service.ExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExemplaireController {
    @Autowired
    ExemplaireService exemplaireService;

    @RequestMapping("/prolonger/{exemplaireId}")
    public Exemplaire prolongerEmprunt(@PathVariable Integer exemplaireId){
        Exemplaire exemplaire = exemplaireService.prolongerEmprunt(exemplaireId);
        return exemplaire;
    }
}
