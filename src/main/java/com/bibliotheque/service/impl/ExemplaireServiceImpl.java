package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.ExemplaireDao;
import com.bibliotheque.modele.entities.Bibliotheque;
import com.bibliotheque.modele.entities.Exemplaire;
import com.bibliotheque.service.ExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ExemplaireServiceImpl implements ExemplaireService {
    @Autowired
    ExemplaireDao exemplaireDao;

    @Override
    public Exemplaire prolongerEmprunt(Integer exemplaireId) {
        Exemplaire exemplaire = chercherExemplaireParId(exemplaireId);
        exemplaire = modificationDateEtProlongation(exemplaire);
        exemplaire.setProlongation(true);
        exemplaireDao.save(exemplaire);
        return exemplaire;
    }

    @Override
    public List<Exemplaire> mesEmprunts(Integer usagerId) {
        List<Exemplaire> exemplaires = exemplaireDao.findAllByUsager_UsagerId(usagerId);
        return exemplaires;
    }

    @Override
    public List<Exemplaire> listerEmprunts() {
        List<Exemplaire> exemplaires = exemplaireDao.findAllByDisponibleFalse();
        return exemplaires;
    }

    @Override
    public void rendreEmprunt(Integer exemplaireId) {
        Exemplaire exemplaire = chercherExemplaireParId(exemplaireId);
        exemplaire.setDisponible(true);
        exemplaire.setProlongation(false);
        exemplaire.setUsager(null);
        exemplaire.setDateDebut(null);
        exemplaire.setDateFin(null);
        exemplaireDao.save(exemplaire);
    }

    @Override
    public String emprunterExemplaire(Exemplaire exemplaire) {
        Exemplaire exemplaireEmprunte = exemplaireDao.findByExemplaireId(exemplaire.getExemplaireId());
        exemplaireEmprunte.setUsager(exemplaire.getUsager());
        exemplaireEmprunte.setDisponible(false);
        exemplaireEmprunte.setProlongation(false);
        exemplaireEmprunte =modificationDateEtProlongation(exemplaireEmprunte);
        exemplaireDao.save(exemplaireEmprunte);
        return String.valueOf(exemplaireEmprunte.getDateFin());
    }

    @Override
    public List<String> listerEmail() {
        List<String> email = new ArrayList<>();
        List<Exemplaire> exemplaires = exemplaireDao.findAllByDateFinBefore(Date.valueOf(LocalDate.now()));
        for (int i = 0; i<exemplaires.size();i++){
            String adresse = exemplaires.get(i).getUsager().getEmail();
            email.add(adresse);
        }
        return email;
    }


    private Exemplaire chercherExemplaireParId(Integer exemplaireId){
        Optional<Exemplaire> exemplaire = exemplaireDao.findById(exemplaireId);
        return exemplaire.isPresent() ? exemplaire.get() :null ;
    }


    private Exemplaire modificationDateEtProlongation(Exemplaire exemplaire){
        // gestion date de début
        if(exemplaire.getDateDebut() == null){
            exemplaire.setDateDebut(Date.valueOf(LocalDate.now()));
        }
        // gestion date de fin
        if(exemplaire.getDateFin() == null){
            exemplaire.setDateFin(Date.valueOf(  LocalDate.now().plusDays(28)));
        }else{
            exemplaire.setDateFin(Date.valueOf(exemplaire.getDateFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(28)));
        }
        return exemplaire;
    }
}
