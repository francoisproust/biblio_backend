package com.bibliotheque.controleur;

import com.bibliotheque.modele.entities.Emprunt;
import com.bibliotheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/emprunt-en-cours")
    public List<Emprunt> listerEmpruntEnCours(){
        List<Emprunt> empruntEnCours = empruntService.listerEmpruntEnCours();
        return empruntEnCours;
    }

    @RequestMapping("/prolonger-emprunt/{emprunt_id}")
    public Emprunt prolongerEmprunt(@PathVariable Integer emprunt_id){
        Emprunt empruntProlonge = new Emprunt();
        empruntProlonge = empruntService.prolongerEmprunt(emprunt_id);
        return empruntProlonge;
    }
}
