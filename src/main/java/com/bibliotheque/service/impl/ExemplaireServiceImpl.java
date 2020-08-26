package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.ExemplaireDao;
import com.bibliotheque.modele.entities.Exemplaire;
import com.bibliotheque.service.ExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
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


    private Exemplaire chercherExemplaireParId(Integer exemplaireId){
        Optional<Exemplaire> exemplaire = exemplaireDao.findById(exemplaireId);
        return exemplaire.isPresent() ? exemplaire.get() :null ;
    }


    private Exemplaire modificationDateEtProlongation(Exemplaire exemplaire){
        exemplaire.setDateDebut(Date.valueOf(LocalDate.now()));
        exemplaire.setDateFin(Date.valueOf(  LocalDate.now().plusDays(28)));
        return exemplaire;
    }
}
