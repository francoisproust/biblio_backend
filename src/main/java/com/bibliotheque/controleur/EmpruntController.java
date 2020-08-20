package com.bibliotheque.controleur;

import com.bibliotheque.modele.entities.Emprunt;
import com.bibliotheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping("/emprunter/{ouvrageId}/{usagerId}")
    public Emprunt creerEmprunt(@PathVariable("ouvrageId") Integer ouvrageId, @PathVariable("usagerId") Integer usagerId){
        Emprunt emprunt = empruntService.creerEmprunt(ouvrageId,usagerId);
        return emprunt;
    }
    
}
