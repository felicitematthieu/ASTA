package com.pam.asta.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "entreprise")
public class Entreprise {
    @Id
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

}