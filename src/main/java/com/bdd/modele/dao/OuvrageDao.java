package com.bdd.modele.dao;

import com.bdd.modele.entities.Ouvrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OuvrageDao extends JpaRepository<Ouvrage,Integer> {
    List<Ouvrage> findAll();
}
