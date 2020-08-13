package com.bibliotheque.controleur;

import com.bibliotheque.modele.entities.Livre;
import com.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivreController {

    @Autowired
    LivreService livreService;

    @RequestMapping("/livre")
    public List<Livre> listerLivre(){
        List<Livre> livres = livreService.listerLivre();
        return livres;
    }
}
