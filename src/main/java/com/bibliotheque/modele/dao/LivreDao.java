package com.bibliotheque.modele.dao;

import com.bibliotheque.modele.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LivreDao extends JpaRepository<Livre, Integer> {
    List<Livre> findAll();
    List<Livre> findAllByOuvrage_OuvrageId(Integer ouvrageId);
}
