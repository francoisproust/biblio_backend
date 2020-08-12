package com.bdd.modele.dao;

import com.bdd.modele.entities.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsagerDao extends JpaRepository<Usager, Integer> {
}
