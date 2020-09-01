package com.bibliotheque.controleur;

import com.bibliotheque.modele.entities.Usager;
import com.bibliotheque.service.UsagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsagerController {
    @Autowired
    UsagerService usagerService;

    @PostMapping("/login")
    public boolean verifierConnexion(@PathVariable Usager usager){
        Boolean loginRetour = usagerService.verifierUsager(usager);
        return loginRetour;
    }

}
