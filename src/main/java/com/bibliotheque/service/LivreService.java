package com.bibliotheque.service;

import com.bibliotheque.modele.entities.Livre;

import java.util.List;

public interface LivreService {
    List<Livre> listerLivre();
    Integer nombreLivreDisponible(Integer ouvrageId);
}
