package com.bibliotheque.controleur;

import com.bibliotheque.modele.entities.Ouvrage;
import com.bibliotheque.service.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
