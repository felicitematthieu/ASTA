package com.pam.asta.modele;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<<< HEAD:src/main/java/com/pam/asta/modele/EntrepriseRepository.java
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
========
import java.util.List;

public interface ApprentiRepository extends JpaRepository<Apprenti, Integer>{

    List<Apprenti> findByProgrammeAndArchiveFalse(String programme);

    List<Apprenti> findByArchiveFalse();
>>>>>>>> 1bffd3d (5 et 6):src/main/java/com/pam/asta/modele/ApprentiRepository.java
}
