package com.pam.asta.modele.Apprenti;

import com.pam.asta.modele.TuteurEnseignant.TuteurEnseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprentiRepository extends JpaRepository<Apprenti, Integer>{
    List<Apprenti> findByTuteurAndAnneeAcademiqueAndArchiveFalse(TuteurEnseignant tuteur, String annee);

    List<Apprenti> findByProgrammeAndArchiveFalse(String programme);

    List<Apprenti> findByArchiveFalse();

    @Query("""
        SELECT DISTINCT a FROM Apprenti a
        LEFT JOIN a.entreprise e
        LEFT JOIN Mission m ON m.apprenti = a
        WHERE a.tuteur = :tuteur
          AND (
              :query IS NULL OR
              LOWER(a.nom) LIKE LOWER(CONCAT('%', :query, '%')) OR
              LOWER(a.prenom) LIKE LOWER(CONCAT('%', :query, '%')) OR
              LOWER(e.raisonSociale) LIKE LOWER(CONCAT('%', :query, '%')) OR
              m.motsCles LIKE CONCAT('%', :query, '%') OR
              LOWER(m.metierCible) LIKE LOWER(CONCAT('%', :query, '%'))
          )
    """)
    List<Apprenti> searchApprentisGlobale(
            @Param("tuteur") TuteurEnseignant tuteur,
            @Param("query") String query
    );
}
