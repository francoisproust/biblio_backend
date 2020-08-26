package com.bibliotheque.service;

import com.bibliotheque.modele.entities.Exemplaire;

import java.util.List;

public interface ExemplaireService {
    Exemplaire prolongerEmprunt(Integer exemplaireId);
    List<Exemplaire> mesEmprunts(Integer usagerId);
}
