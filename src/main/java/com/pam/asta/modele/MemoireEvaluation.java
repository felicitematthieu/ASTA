package com.pam.asta.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "memoire_evaluation")
public class MemoireEvaluation {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
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

}