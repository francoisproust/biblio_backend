package com.bdd.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="livre", schema = "public")
public class Livre {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    @Column (name = "livre_id",nullable = false)
    private Integer livreId;
    @Column (name = "nom",nullable = false,length = 255)
    private String nom;
    @Column (name = "auteur",nullable = false,length = 255)
    private String auteur;
    @Column (name = "isbn",nullable = false,length = 13)
    private Integer isbn;

    @ManyToOne
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrageId;

    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.ALL)
    private Set<Emprunt> emprunts;

    public Integer getLivreId() {
        return livreId;
    }

    public void setLivreId(Integer livreId) {
        this.livreId = livreId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Ouvrage getOuvrageId() {
        return ouvrageId;
    }

    public void setOuvrageId(Ouvrage ouvrageId) {
        this.ouvrageId = ouvrageId;
    }
}
