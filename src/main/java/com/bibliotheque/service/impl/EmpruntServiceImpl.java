package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.EmpruntDao;
import com.bibliotheque.modele.dao.LivreDao;
import com.bibliotheque.modele.dao.OuvrageDao;
import com.bibliotheque.modele.dao.UsagerDao;
import com.bibliotheque.modele.entities.Emprunt;
import com.bibliotheque.modele.entities.Livre;
import com.bibliotheque.modele.entities.Ouvrage;
import com.bibliotheque.modele.entities.Usager;
import com.bibliotheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpruntServiceImpl implements EmpruntService {
    @Autowired
    EmpruntDao empruntDao;
    @Autowired
    UsagerDao usagerDao;
    @Autowired
    LivreDao livreDao;
   // OuvrageDao ouvrageDao;
    @Override
    public List<Emprunt> listerEmprunt() {
        List<Emprunt> emprunts = empruntDao.findAll();
        return emprunts;
    }

    @Override
    public List<Emprunt> listerEmpruntEnCours() {
        List<Emprunt> empruntEnCours = new ArrayList<>();
        List<Emprunt> emprunts = empruntDao.findAll();
        for (int i=0; i<emprunts.size();i++){
            if (emprunts.get(i).getEtat().equals("En cours")){
               empruntEnCours.add(emprunts.get(i));
            }
        }
        return empruntEnCours;
    }

    @Override
    public Emprunt prolongerEmprunt(Integer emprunt_id) {
        Emprunt emprunt = new Emprunt();
        emprunt = empruntDao.findByEmpruntId(emprunt_id);
        if (!emprunt.getProlongation()){
            emprunt.setProlongation(true);
            emprunt = creationDate(emprunt);
            empruntDao.save(emprunt);
        }
        return emprunt;
    }

    @Override
    public Emprunt creerEmprunt(Integer ouvrageId,Integer usagerId) {
        Emprunt empruntCree = new Emprunt();
        empruntCree.setUsager(chercherUsagerParId(usagerId));
        empruntCree = creationDate(empruntCree);
        empruntCree.setLivre(chercherLivreDisponibleParOuvrage(ouvrageId));
        empruntCree.setProlongation(false);
        empruntCree.setEtat("En cours");
        empruntDao.save(empruntCree);
        return empruntCree;
    }

    private Emprunt creationDate(Emprunt emprunt){
        emprunt.setDateDebut(Date.valueOf(LocalDate.now()));
        emprunt.setDateFin(Date.valueOf(  LocalDate.now().plusDays(28)));
        return emprunt;
    }

    private Usager chercherUsagerParId(Integer usagerId){
        Optional<Usager> usager = usagerDao.findById(usagerId);
        return usager.isPresent() ? usager.get() : null;
    }

    private Livre chercherLivreDisponibleParOuvrage(Integer ouvrageId){
        Livre livreEmprunte = new Livre();
        List<Livre> livres = livreDao.findAllByOuvrage_OuvrageId(ouvrageId);
        for(int i=0; i<livres.size();i++){
            if (livres.get(i).getDisponible()){
                livreEmprunte = livres.get(i);
                livreEmprunte.setDisponible(false);
                break;
            }
        }
        livreDao.save(livreEmprunte);
        return livreEmprunte;
    }
}
