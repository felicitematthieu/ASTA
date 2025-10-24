package com.pam.asta.modele;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "soutenance_evaluation")
public class SoutenanceEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluation_id")
    private EvaluationEcole evaluation;

    @Column(name = "date_soutenance")
    private LocalDate dateSoutenance;

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

    public LocalDate getDateSoutenance() {
        return dateSoutenance;
    }

    public void setDateSoutenance(LocalDate dateSoutenance) {
        this.dateSoutenance = dateSoutenance;
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