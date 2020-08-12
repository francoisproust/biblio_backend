package com.bdd.modele.dao;

import com.bdd.modele.entities.TypeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeUserDao extends JpaRepository<TypeUser,Integer> {
}
