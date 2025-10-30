package com.pam.asta.controleur.Apprenti;

import com.pam.asta.modele.Apprenti.Apprenti;
import com.pam.asta.modele.Apprenti.ApprentiRepository;
import com.pam.asta.modele.TuteurEnseignant.TuteurEnseignant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprentiService {

    public final ApprentiRepository apprentiRepository;

    public ApprentiService(ApprentiRepository apprentiRepository) {
        this.apprentiRepository = apprentiRepository;
    }

    public List<Apprenti> getApprentisPourTuteurAnneeCourante(TuteurEnseignant tuteurEnseignant, String annee) {
        return apprentiRepository.findByTuteurEnseignantAndAnneeAcademique(tuteurEnseignant, annee);
    }
}
