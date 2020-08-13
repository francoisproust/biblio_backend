package com.bibliotheque.modele.dao;

import com.bibliotheque.modele.entities.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsagerDao extends JpaRepository<Usager, Integer> {
}
