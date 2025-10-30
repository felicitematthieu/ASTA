package com.pam.asta.modele;

import com.pam.asta.modele.Apprenti.Apprenti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

    List<Apprenti> findByProgrammeAndArchiveFalse(String programme);

    List<Apprenti> findByArchiveFalse();
}
