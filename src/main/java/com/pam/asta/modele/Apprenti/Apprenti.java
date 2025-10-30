package com.pam.asta.modele.Apprenti;

import com.pam.asta.modele.Entreprise;
import com.pam.asta.modele.MaitreApprentissage;
import com.pam.asta.modele.TuteurEnseignant.TuteurEnseignant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "apprenti")
public class Apprenti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "programme", length = 100)
    private String programme;

    @Column(name = "annee_academique", length = 20)
    private String anneeAcademique;

    @Column(name = "majeure", length = 100)
    private String majeure;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 100)
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone", length = 10)
    private String telephone;

    @ColumnDefault("0")
    @Column(name = "archive")
    private Boolean archive;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entreprise_id", nullable = false)
    private Entreprise entreprise;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tuteur_id", nullable = false)
    private TuteurEnseignant tuteur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "maitre_apprentissage", nullable = false)
    private MaitreApprentissage maitreApprentissage;

}