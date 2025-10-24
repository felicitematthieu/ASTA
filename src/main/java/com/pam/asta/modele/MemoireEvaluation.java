package com.pam.asta.modele;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "memoire_evaluation")
public class MemoireEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluation_id")
    private EvaluationEcole evaluation;

    @Lob
    @Column(name = "theme_sujet")
    private String themeSujet;

    @Column(name = "note", precision = 4, scale = 2)
    private BigDecimal note;

    @Lob
    @Column(name = "commentaires")
    private String commentaires;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EvaluationEcole getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(EvaluationEcole evaluation) {
        this.evaluation = evaluation;
    }

    public String getThemeSujet() {
        return themeSujet;
    }

    public void setThemeSujet(String themeSujet) {
        this.themeSujet = themeSujet;
    }

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

}