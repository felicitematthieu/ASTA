package com.pam.asta.modele.TuteurEnseignant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tuteur_enseignant")
public class TuteurEnseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 100)
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone", length = 10)
    private String telephone;

    @Column(name = "password", nullable = false)
    private String password;

}