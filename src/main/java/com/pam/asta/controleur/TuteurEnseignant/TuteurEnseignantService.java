package com.pam.asta.controleur.TuteurEnseignant;

import com.pam.asta.modele.TuteurEnseignant.TuteurEnseignant;
import com.pam.asta.modele.TuteurEnseignant.TuteurEnseignantRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TuteurEnseignantService implements UserDetailsService {

    private TuteurEnseignantRepository tuteurEnseignantRepository;

    public TuteurEnseignantService(TuteurEnseignantRepository tuteurEnseignantRepository) {
        this.tuteurEnseignantRepository = tuteurEnseignantRepository;
    }

    public TuteurEnseignant findByEmail(String email) {
        return tuteurEnseignantRepository.findByEmail(email).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        TuteurEnseignant tuteur = tuteurEnseignantRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Aucun utilisateur avec l'email : " + email));

        return User.builder()
                .username(tuteur.getEmail())
                .password(tuteur.getPassword())
                .roles("USER")
                .build();
    }
}
