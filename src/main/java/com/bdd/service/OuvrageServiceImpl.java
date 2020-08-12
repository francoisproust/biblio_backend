package com.bdd.service;

import com.bdd.modele.dao.OuvrageDao;
import com.bdd.modele.entities.Ouvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OuvrageServiceImpl implements OuvrageService {
    @Autowired
    OuvrageDao ouvrageDao;
    @Override
    public List<Ouvrage> listerOuvrage() {
        List<Ouvrage> ouvrages = ouvrageDao.findAll();
        return ouvrages;
    }
}
