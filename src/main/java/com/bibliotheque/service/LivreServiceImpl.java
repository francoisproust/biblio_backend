package com.bibliotheque.service;

import com.bibliotheque.modele.dao.LivreDao;
import com.bibliotheque.modele.entities.Livre;
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

    @Override
    public Integer nombreLivreDisponible(Integer ouvrageId) {
        Integer nombreDispo = 0;
        List<Livre> livresParOuvrage = livreDao.findAllByOuvrage_OuvrageId(ouvrageId);
        for(int i=0; i<livresParOuvrage.size();i++){
            if (livresParOuvrage.get(i).getDisponible()){
                nombreDispo = nombreDispo + 1;
            }
        }
        return nombreDispo;
    }
}
