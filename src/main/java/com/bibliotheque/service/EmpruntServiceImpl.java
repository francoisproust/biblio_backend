package com.bibliotheque.service;

import com.bibliotheque.modele.dao.EmpruntDao;
import com.bibliotheque.modele.entities.Emprunt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpruntServiceImpl implements EmpruntService {
    @Autowired
    EmpruntDao empruntDao;
    @Override
    public List<Emprunt> listerEmprunt() {
        List<Emprunt> emprunts = empruntDao.findAll();
        return emprunts;
    }
}
