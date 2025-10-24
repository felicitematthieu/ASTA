package com.pam.asta.modele;

import jakarta.persistence.*;

@Entity
@Table(name = "entreprise")
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "raison_sociale", nullable = false)
    private String raisonSociale;

    @Lob
    @Column(name = "adresse")
    private String adresse;

    @Lob
    @Column(name = "informations_acces")
    private String informationsAcces;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getInformationsAcces() {
        return informationsAcces;
    }

    public void setInformationsAcces(String informationsAcces) {
        this.informationsAcces = informationsAcces;
    }

}