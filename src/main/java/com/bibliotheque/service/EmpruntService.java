package com.bibliotheque.service;

import com.bibliotheque.modele.entities.Emprunt;

import java.util.List;

public interface EmpruntService {
    List<Emprunt> listerEmprunt();
}