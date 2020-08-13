package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.UsagerDao;
import com.bibliotheque.modele.entities.Usager;
import com.bibliotheque.service.UsagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsagerServiceImpl implements UsagerService {
    @Autowired
    UsagerDao usagerDao;
    @Override
    public void ajouterUsager(Usager usager) {
        usagerDao.save(usager);
    }

    @Override
    public UserDetails loadUserByUsername(String identifiant) throws UsernameNotFoundException {
        Usager usager = chercherUsagerParIdentifiant(identifiant);
        if (usager == null){
            throw new UsernameNotFoundException(identifiant + "non trouvé");
        }
        return usager;
    }

    private Usager chercherUsagerParIdentifiant(String identifiant){
        Optional<Usager> usager= usagerDao.findUsagerByIdentifiant(identifiant);
        return usager.isPresent() ? usager.get() : null;
    }
}
