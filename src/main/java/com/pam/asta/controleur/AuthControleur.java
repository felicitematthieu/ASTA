package com.pam.asta.controleur;

import com.pam.asta.modele.TuteurEnseignant;
import com.pam.asta.modele.TuteurEnseignantRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthControleur {

    private final TuteurEnseignantRepository tuteurEnseignantRepository;

    public AuthControleur(TuteurEnseignantRepository tuteurEnseignantRepository) {
        this.tuteurEnseignantRepository = tuteurEnseignantRepository;
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {

        if (error != null) {
            model.addAttribute("errorMsg", "Email ou mot de passe invalide.");
        }

        return "login";
    }

    @GetMapping("/home")
    public String homePage(Authentication authentication, Model model) {
        String email = authentication.getName();

        TuteurEnseignant tuteur = tuteurEnseignantRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable : " + email));

        model.addAttribute("prenom", tuteur.getPrenom());

        return "home";
    }
}