package com.pam.asta.controleur;

import com.pam.asta.controleur.Apprenti.ApprentiService;
import com.pam.asta.modele.Apprenti.Apprenti;
import com.pam.asta.modele.TuteurEnseignant.TuteurEnseignant;
import com.pam.asta.modele.TuteurEnseignant.TuteurEnseignantRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthControleur {

    private final TuteurEnseignantRepository tuteurEnseignantRepository;
    private final ApprentiService apprentiService;

    public AuthControleur(TuteurEnseignantRepository tuteurEnseignantRepository,  ApprentiService apprentiService) {
        this.tuteurEnseignantRepository = tuteurEnseignantRepository;
        this.apprentiService = apprentiService;
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
    public String homePage(Authentication authentication,
                           @RequestParam(value = "annee", required = false) String annee,
                           @RequestParam(value = "search", required = false) String search,
                           Model model) {

        String email = authentication.getName();
        TuteurEnseignant tuteur = tuteurEnseignantRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Tuteur non trouvé : " + email));

        List<String> anneesDisponibles = List.of("2022-2023", "2023-2024", "2024-2025");
        String anneeSelectionnee = (annee != null) ? annee : "2024-2025";

        List<Apprenti> apprentis;
        if (search != null && !search.isEmpty()) {
            apprentis = apprentiService.rechercherApprentisGlobale(tuteur, search);
        } else {
            apprentis = apprentiService.getApprentisPourTuteurAnneeCourante(tuteur, anneeSelectionnee);
        }

        model.addAttribute("prenom", tuteur.getPrenom());
        model.addAttribute("apprentis", apprentis);
        model.addAttribute("annees", anneesDisponibles);
        model.addAttribute("anneeSelectionnee", anneeSelectionnee);
        model.addAttribute("search", search);

        return "home";
    }
}