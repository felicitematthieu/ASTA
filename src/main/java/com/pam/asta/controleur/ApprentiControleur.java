package com.pam.asta.controleur;

import com.pam.asta.modele.Apprenti;
import com.pam.asta.modele.EntrepriseRepository;
import com.pam.asta.modele.MaitreApprentissageRepository;
import com.pam.asta.modele.TuteurEnseignantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.pam.asta.service.ApprentiService;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("ASTA")
public class ApprentiControleur {
    private final ApprentiService apprentiservice;
    private final EntrepriseRepository entrepriseRepository;
    private final MaitreApprentissageRepository maitreApprentissageRepository;
    private final TuteurEnseignantRepository tuteurEnseignantRepository;

    public ApprentiControleur(ApprentiService apprentiservice, EntrepriseRepository entrepriseRepository, MaitreApprentissageRepository maitreApprentissageRepository, TuteurEnseignantRepository tuteurEnseignantRepository) {
        this.apprentiservice = apprentiservice;
        this.entrepriseRepository = entrepriseRepository;
        this.maitreApprentissageRepository = maitreApprentissageRepository;
        this.tuteurEnseignantRepository = tuteurEnseignantRepository;
    }

    @GetMapping("/ajouterApprenti")
    public String preparerAjoutApprenti(Model model) {
        model.addAttribute("nouvelApprenti", new Apprenti());
        model.addAttribute("entreprises", entrepriseRepository.findAll());
        model.addAttribute("maitres", maitreApprentissageRepository.findAll());
        model.addAttribute("tuteurs", tuteurEnseignantRepository.findAll());
        return "nouvelApprenti";
    }

    @PostMapping("/ajouterApprenti")
    public String creerApprenti(@ModelAttribute("nouvelApprenti") Apprenti apprenti, RedirectAttributes redirectAttributes) {
        apprentiservice.ajouterApprenti(apprenti);
        redirectAttributes.addAttribute("success", true);
        return "redirect:/ASTA/ajouterApprenti";
    }

    @GetMapping("/nouvelleAnnee")
    public String preparerNouvelleAnnee() {
        return "nouvelleAnnee";
    }

    @PostMapping("/nouvelleAnnee")
    public String creerNouvelleAnnee(@RequestParam("annee") String annee) {
        apprentiservice.creerNouvelleAnneeAcademique(annee);
        return "redirect:/ASTA/nouvelleAnnee";
    }
}
