package com.bdd.modele.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="emprunt", schema = "public")
public class Emprunt {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    @Column (name = "emprunt_id",nullable = false)
    private Integer empruntId;
    @Column(name = "date_debut", nullable = false)
    private Date dateDebut;
    @Column(name = "date_fin", nullable = false)
    private Date dateFin;
    @Column(name = "prolongation", nullable = false)
    private Boolean prolongation;
    @Column(name = "etat", nullable = false, length = 32)
    private String etat;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "livre_id")
    private Livre livre;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usager_id")
    private Usager usager;

    public Integer getEmpruntId() {
        return empruntId;
    }

    public void setEmpruntId(Integer empruntId) {
        this.empruntId = empruntId;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Boolean getProlongation() {
        return prolongation;
    }

    public void setProlongation(Boolean prolongation) {
        this.prolongation = prolongation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Usager getUsager() {
        return usager;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }
}
