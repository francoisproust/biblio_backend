package com.bibliotheque.modele.dao;

import com.bibliotheque.modele.entities.Ouvrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExemplaireDao extends JpaRepository<Ouvrage,Integer> {
}
