package com.pam.asta.modele;

import com.pam.asta.modele.Apprenti.Apprenti;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "visite")
public class Visite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public LocalDate getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(LocalDate dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getFormatVisite() {
        return formatVisite;
    }

    public void setFormatVisite(String formatVisite) {
        this.formatVisite = formatVisite;
    }

    public Apprenti getApprenti() {
        return apprenti;
    }

    public void setApprenti(Apprenti apprenti) {
        this.apprenti = apprenti;
    }

}