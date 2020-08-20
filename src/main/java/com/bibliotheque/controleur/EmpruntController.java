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

    @PostMapping(value = "/emprunter")
    public ResponseEntity<Void> creerEmprunt(@RequestBody Emprunt emprunt){
        Emprunt empruntCreer = empruntService.creerEmprunt(emprunt);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(empruntCreer.getEmpruntId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    
}
