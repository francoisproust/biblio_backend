package com.bibliotheque.controleur;

import com.bibliotheque.modele.entities.Ouvrage;
import com.bibliotheque.service.LivreService;
import com.bibliotheque.service.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OuvrageController {
    @Autowired
    OuvrageService ouvrageService;
    @Autowired
    LivreService livreService;

    @RequestMapping("/ouvrage")
    public List<Ouvrage> listerOuvrage(){
        List<Ouvrage> ouvrages = ouvrageService.listerOuvrage();
        return ouvrages;
    }

    @RequestMapping("/ouvrage-disponible/{ouvrageId}")
    public Integer nombreOuvrageDispo(@PathVariable Integer ouvrageId){
        Integer nombreDispo = livreService.nombreLivreDisponible(ouvrageId) ;
        return nombreDispo;
    }
}
