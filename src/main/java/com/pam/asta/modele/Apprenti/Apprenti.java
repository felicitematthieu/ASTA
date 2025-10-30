package com.pam.asta.modele.Apprenti;

import com.pam.asta.modele.Entreprise;
import com.pam.asta.modele.TuteurEnseignant.TuteurEnseignant;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entreprise_id", nullable = false)
    private Entreprise entreprise;

    @ColumnDefault("0")
    @Column(name = "archive")
    private Boolean archive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tuteur_enseignant_id")
    private TuteurEnseignant tuteurEnseignant;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(String anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }

    public String getMajeure() {
        return majeure;
    }

    public void setMajeure(String majeure) {
        this.majeure = majeure;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public TuteurEnseignant getTuteurEnseignant() {
        return tuteurEnseignant;
    }

    public void setTuteurEnseignant(TuteurEnseignant tuteurEnseignant) {
        this.tuteurEnseignant = tuteurEnseignant;
    }

}