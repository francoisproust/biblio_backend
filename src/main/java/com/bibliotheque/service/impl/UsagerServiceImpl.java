package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.UsagerDao;
import com.bibliotheque.modele.entities.Usager;
import com.bibliotheque.service.UsagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsagerServiceImpl implements UsagerService {
    @Autowired
    UsagerDao usagerDao;
    @Override
    public void ajouterUsager(Usager usager) {
        usagerDao.save(usager);
    }
}