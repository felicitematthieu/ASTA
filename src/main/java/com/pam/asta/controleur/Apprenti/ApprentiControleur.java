package com.pam.asta.controleur.Apprenti;

import com.pam.asta.controleur.TuteurEnseignant.TuteurEnseignantService;
import com.pam.asta.modele.Apprenti.Apprenti;
import com.pam.asta.modele.TuteurEnseignant.TuteurEnseignant;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Year;
import java.util.List;

@Controller
public class ApprentiControleur {

    public final TuteurEnseignantService tuteurEnseignantService;
    public final ApprentiService apprentiService;

    public ApprentiControleur(TuteurEnseignantService tuteurEnseignantService, ApprentiService apprentiService) {
        this.tuteurEnseignantService = tuteurEnseignantService;
        this.apprentiService = apprentiService;
    }
}
