package com.bibliotheque.service;

import com.bibliotheque.modele.entities.Exemplaire;

public interface ExemplaireService {
    Exemplaire prolongerEmprunt(Integer exemplaireId);
}
