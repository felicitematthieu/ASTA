package com.pam.asta.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "soutenance_evaluation")
public class SoutenanceEvaluation {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "evaluation_id")
    private EvaluationEcole evaluation;

    @Column(name = "date_soutenance")
    private LocalDate dateSoutenance;

    @Column(name = "note", precision = 4, scale = 2)
    private BigDecimal note;

    @Lob
    @Column(name = "commentaires")
    private String commentaires;

}