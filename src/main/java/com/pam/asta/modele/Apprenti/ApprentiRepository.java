package com.pam.asta.modele.Apprenti;

import com.pam.asta.modele.TuteurEnseignant.TuteurEnseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprentiRepository extends JpaRepository<Apprenti, Integer>{
    List<Apprenti> findByTuteurEnseignantAndAnneeAcademique(TuteurEnseignant tuteur, String annee);
}
