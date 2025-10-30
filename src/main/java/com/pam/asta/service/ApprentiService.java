package com.pam.asta.service;

import com.pam.asta.exceptions.ApprentiNonTrouveException;
import com.pam.asta.modele.Apprenti;
import com.pam.asta.modele.ApprentiRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ApprentiService {

    private final ApprentiRepository apprentiRepository;
    public ApprentiService(ApprentiRepository apprentiRepository) {
        this.apprentiRepository = apprentiRepository;
    }

    @Transactional
    public void ajouterApprenti(Apprenti apprenti) {
        apprenti.setArchive(false);
        apprentiRepository.save(apprenti);
    }

    @Transactional
    public void creerNouvelleAnneeAcademique(String nouvelleAnnee) {
        // Archiver les apprentis de I3
        List<Apprenti> apprentisI3 = apprentiRepository.findByProgrammeAndArchiveFalse("I3");
        for (Apprenti apprenti : apprentisI3) {
            apprenti.setArchive(true);
        }

        // Promouvoir les apprentis de I2 -> I3
        List<Apprenti> apprentisI2 = apprentiRepository.findByProgrammeAndArchiveFalse("I2");
        for (Apprenti apprenti : apprentisI2) {
            apprenti.setProgramme("I3");
            apprenti.setAnneeAcademique(nouvelleAnnee);
        }

        //Promouvoir les apprentis de I1 -> I2
        List<Apprenti> apprentisI1 = apprentiRepository.findByProgrammeAndArchiveFalse("I1");
        for (Apprenti apprenti : apprentisI1) {
            apprenti.setProgramme("I2");
            apprenti.setAnneeAcademique(nouvelleAnnee);
        }

        //Sauvegarder tout
        apprentiRepository.saveAll(apprentisI3);
        apprentiRepository.saveAll(apprentisI2);
        apprentiRepository.saveAll(apprentisI1);
    }

    public List<Apprenti> getApprentisActifs() {
        return apprentiRepository.findByArchiveFalse();
    }

    public Optional<Apprenti> getUnApprenti(Integer idApprenti) {
        Optional<Apprenti> unApprenti = apprentiRepository.findById(idApprenti);

        return Optional.ofNullable(
                unApprenti.orElseThrow(
                        () -> new ApprentiNonTrouveException(
                                "Le programmeur dont l\'id est " + idApprenti + " n\'existe pas")));
    }

    @Transactional
    public void modifierApprenti(Integer idApprenti, Apprenti apprentiModified) {
        Apprenti apprentiToModify = apprentiRepository.findById(idApprenti).orElseThrow();

        if (apprentiToModify != null) {
            BeanUtils.copyProperties(apprentiModified, apprentiToModify, "id");
            apprentiRepository.save(apprentiToModify);
        }
    }
}
