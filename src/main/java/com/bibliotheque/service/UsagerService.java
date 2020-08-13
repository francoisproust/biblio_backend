package com.bibliotheque.service;

import com.bibliotheque.modele.entities.Usager;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsagerService extends UserDetailsService {
    void ajouterUsager(Usager usager);
}
