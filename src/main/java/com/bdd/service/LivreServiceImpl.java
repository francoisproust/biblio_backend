package com.bdd.service;

import com.bdd.modele.dao.LivreDao;
import com.bdd.modele.entities.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {
    @Autowired
    LivreDao livreDao;

    public List<Livre> listerLivre(){
        List<Livre> livres = livreDao.findAll();
        return livres;
    }
}
