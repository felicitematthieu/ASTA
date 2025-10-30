package com.pam.asta.modele;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApprentiRepository extends JpaRepository<Apprenti, Integer>{

    List<Apprenti> findByProgrammeAndArchiveFalse(String programme);

    List<Apprenti> findByArchiveFalse();
}
