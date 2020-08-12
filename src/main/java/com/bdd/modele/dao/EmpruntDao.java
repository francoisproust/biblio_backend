package com.bdd.modele.dao;

import com.bdd.modele.entities.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpruntDao extends JpaRepository<Emprunt,Integer> {
    List<Emprunt> findAll();
}
