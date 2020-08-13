package com.bibliotheque.modele.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="usager", schema = "public")
public class Usager {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    @Column (name = "usager_id",nullable = false)
    private Integer usagerId;
    @Column (name = "nom",nullable = false,length = 55)
    private String nom;
    @Column (name = "prenom",nullable = false,length = 55)
    private String prenom;
    @Column (name = "identifiant",nullable = false,length = 55)
    private String identifiant;
    @Column (name = "password",nullable = false,length = 32)
    private String password;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeUser typeUser;

    @OneToMany(mappedBy = "usager", cascade = CascadeType.ALL)
    private Set<Emprunt> emprunts;

    public Integer getUsagerId() {
        return usagerId;
    }

    public void setUsagerId(Integer usagerId) {
        this.usagerId = usagerId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}
