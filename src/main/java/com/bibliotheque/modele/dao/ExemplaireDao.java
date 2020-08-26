package com.bibliotheque.modele.dao;

import com.bibliotheque.modele.entities.Exemplaire;
import com.bibliotheque.modele.entities.Ouvrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExemplaireDao extends JpaRepository<Exemplaire,Integer> {
    List<Exemplaire> findAllByUsager_UsagerId(Integer ouvrageId);
    List<Exemplaire> findAllByDisponibleFalse();

}
