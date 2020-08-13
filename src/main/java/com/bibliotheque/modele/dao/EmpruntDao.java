package com.bibliotheque.modele.dao;

import com.bibliotheque.modele.entities.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpruntDao extends JpaRepository<Emprunt,Integer> {
    List<Emprunt> findAll();
    Emprunt findByEmpruntId(Integer emprunt_id);
}
