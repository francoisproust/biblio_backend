package com.bibliotheque.service;

import com.bibliotheque.modele.entities.Usager;

public interface UsagerService {
    void ajouterUsager(Usager usager);
    Boolean verifierUsager(Usager usager);
}
