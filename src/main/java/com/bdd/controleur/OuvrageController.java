package com.bdd.controleur;

import com.bdd.modele.entities.Livre;
import com.bdd.modele.entities.Ouvrage;
import com.bdd.service.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OuvrageController {
    @Autowired
    OuvrageService ouvrageService;

    @RequestMapping("/ouvrage")
    public List<Ouvrage> listerOuvrage(){
        List<Ouvrage> ouvrages = ouvrageService.listerOuvrage();
        return ouvrages;
    }
}
