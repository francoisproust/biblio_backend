package com.bdd.modele.dao;

import com.bdd.modele.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LivreDao extends JpaRepository<Livre, Integer> {
    List<Livre> findAll();
}
