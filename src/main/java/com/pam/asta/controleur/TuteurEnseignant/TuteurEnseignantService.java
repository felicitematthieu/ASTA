package com.pam.asta.controleur.TuteurEnseignant;

import com.pam.asta.modele.TuteurEnseignant;
import com.pam.asta.modele.TuteurEnseignantRepository;
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
