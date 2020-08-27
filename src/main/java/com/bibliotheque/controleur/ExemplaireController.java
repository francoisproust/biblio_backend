package com.bibliotheque.controleur;

import com.bibliotheque.modele.entities.Exemplaire;
import com.bibliotheque.service.ExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExemplaireController {
    @Autowired
    ExemplaireService exemplaireService;

    @RequestMapping("/prolonger/{exemplaireId}")
    public Exemplaire prolongerEmprunt(@PathVariable Integer exemplaireId){
        Exemplaire exemplaire = exemplaireService.prolongerEmprunt(exemplaireId);
        return exemplaire;
    }

    @RequestMapping("/consulter-emprunts/{usagerId}")
    public List<Exemplaire> consulterMesEmprunts(@PathVariable Integer usagerId){
        List<Exemplaire> emprunts = exemplaireService.mesEmprunts(usagerId);
        return emprunts;
    }

    @RequestMapping("/consulter-emprunts")
    public List<Exemplaire> consulterEmprunts(){
        List<Exemplaire> emprunts = exemplaireService.listerEmprunts();
        return emprunts;
    }

    @RequestMapping("/rendre-emprunt/{exemplaireId}")
    public String rendreEmprunt(@PathVariable Integer exemplaireId){
        exemplaireService.rendreEmprunt(exemplaireId);

        return "l'exemplaire est rendu";
    }
}
