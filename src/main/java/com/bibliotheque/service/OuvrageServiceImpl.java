package com.bibliotheque.service;

import com.bibliotheque.modele.dao.OuvrageDao;
import com.bibliotheque.modele.entities.Ouvrage;
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
