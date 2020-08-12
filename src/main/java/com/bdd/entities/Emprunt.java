package com.bdd.entities;

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
    @JoinColumn(name = "livre_id")
    private Livre livreId;

    @ManyToOne
    @JoinColumn(name = "usager_id")
    private Usager usagerId;

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

    public Livre getLivreId() {
        return livreId;
    }

    public void setLivreId(Livre livreId) {
        this.livreId = livreId;
    }

    public Usager getUsagerId() {
        return usagerId;
    }

    public void setUsagerId(Usager usagerId) {
        this.usagerId = usagerId;
    }
}
