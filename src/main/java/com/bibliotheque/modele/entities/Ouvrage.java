package com.bibliotheque.modele.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="ouvrage", schema = "public")
public class Ouvrage implements Serializable {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    @Column (name = "ouvrage_id",nullable = false)
    private Integer ouvrageId;
    @Column (name = "nom",nullable = false,length = 255)
    private String nom;

    @OneToMany(mappedBy = "ouvrage", cascade = CascadeType.ALL)
    private Set<Livre> livres;

    public Integer getOuvrageId() {
        return ouvrageId;
    }

    public void setOuvrageId(Integer ouvrageId) {
        this.ouvrageId = ouvrageId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }
}
