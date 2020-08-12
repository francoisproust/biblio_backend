package com.bdd.modele.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigInteger;
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
    private BigInteger isbn;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrage;

    @OneToMany(mappedBy = "livre", cascade = CascadeType.ALL)
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

    public BigInteger getIsbn() {
        return isbn;
    }

    public void setIsbn(BigInteger isbn) {
        this.isbn = isbn;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}
