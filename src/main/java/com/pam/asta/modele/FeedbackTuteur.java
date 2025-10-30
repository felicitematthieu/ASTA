package com.pam.asta.modele;

import com.pam.asta.modele.Apprenti.Apprenti;
import com.pam.asta.modele.TuteurEnseignant.TuteurEnseignant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "feedback_tuteur")
public class FeedbackTuteur {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "commentaires")
    private String commentaires;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "tuteur_enseignant_id")
    private TuteurEnseignant tuteurEnseignant;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "apprenti_id")
    private Apprenti apprenti;

}