package com.pam.asta.modele;

import com.pam.asta.modele.Apprenti.Apprenti;
import com.pam.asta.modele.TuteurEnseignant.TuteurEnseignant;
import jakarta.persistence.*;

@Entity
@Table(name = "feedback_tuteur")
public class FeedbackTuteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "commentaires")
    private String commentaires;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tuteur_enseignant_id")
    private TuteurEnseignant tuteurEnseignant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apprenti_id")
    private Apprenti apprenti;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public TuteurEnseignant getTuteurEnseignant() {
        return tuteurEnseignant;
    }

    public void setTuteurEnseignant(TuteurEnseignant tuteurEnseignant) {
        this.tuteurEnseignant = tuteurEnseignant;
    }

    public Apprenti getApprenti() {
        return apprenti;
    }

    public void setApprenti(Apprenti apprenti) {
        this.apprenti = apprenti;
    }

}