package com.bdd.service;

import com.bdd.modele.entities.Livre;
import org.springframework.stereotype.Service;
import java.util.List;

public interface LivreService {
    List<Livre> listerLivre();
}
