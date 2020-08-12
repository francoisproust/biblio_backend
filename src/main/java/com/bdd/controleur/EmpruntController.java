package com.bdd.controleur;

import com.bdd.modele.entities.Emprunt;
import com.bdd.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpruntController {
    @Autowired
    EmpruntService empruntService;

    @RequestMapping("/emprunt")
    public List<Emprunt> listerEmprunt(){
        List<Emprunt> emprunts = empruntService.listerEmprunt();
        return emprunts;
    }
}
