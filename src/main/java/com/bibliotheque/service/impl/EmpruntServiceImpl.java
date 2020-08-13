package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.EmpruntDao;
import com.bibliotheque.modele.entities.Emprunt;
import com.bibliotheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

@Service
public class EmpruntServiceImpl implements EmpruntService {
    @Autowired
    EmpruntDao empruntDao;
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
            emprunt.setDateDebut(Date.valueOf(LocalDate.now()));
            emprunt.setDateFin(Date.valueOf(  LocalDate.now().plusDays(28)));
            empruntDao.save(emprunt);
        }
        return emprunt;
    }
}
