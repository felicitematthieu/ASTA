package com.pam.asta.modele;

import com.pam.asta.modele.Apprenti.Apprenti;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "visite")
public class Visite {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "commentaires")
    private String commentaires;

    @Column(name = "date_visite")
    private LocalDate dateVisite;

    @Lob
    @Column(name = "format_visite")
    private String formatVisite;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "apprenti_id")
    private Apprenti apprenti;

}