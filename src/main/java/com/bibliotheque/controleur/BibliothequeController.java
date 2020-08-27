package com.bibliotheque.controleur;

import com.bibliotheque.modele.entities.Bibliotheque;
import com.bibliotheque.modele.entities.Exemplaire;
import com.bibliotheque.modele.entities.Ouvrage;
import com.bibliotheque.service.BibliothequeService;
import com.bibliotheque.service.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BibliothequeController {
    @Autowired
    BibliothequeService bibliothequeService;

    @Autowired
    OuvrageService ouvrageService;

    @RequestMapping("/rechercher-ouvrage/{biblioId}")
    public List<Ouvrage> rechercherOuvrageParBiblio(@PathVariable Integer biblioId){
        List<Ouvrage> ouvrages = ouvrageService.chercherOuvragresDispo(biblioId);
        return ouvrages;
    }

    @RequestMapping("/bibliotheque")
    public List<Bibliotheque> listerExemplaires(){
        List<Bibliotheque> bibliotheques = bibliothequeService.listerBiblio();
        return bibliotheques;
    }
}
