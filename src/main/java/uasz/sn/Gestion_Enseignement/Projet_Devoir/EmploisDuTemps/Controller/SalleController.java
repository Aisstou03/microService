package uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Modele.Salle;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Service.SalleService;

@Controller
public class SalleController {
    @Autowired
    private SalleService salleService;

    @RequestMapping(value = "/ajouter_salle_batiment", method = RequestMethod.POST)
    public String ajouter_salle_batiment(Model model, Salle salle){
        salleService.ajouterSalle(salle);
        return "redirect:/details_batiment?id="+salle.getBatiment().getId();
    }

    @RequestMapping(value = "/modifier_salle_batiment", method = RequestMethod.POST)
    public String modifier_classe_formation(Model model, Salle salle){
        salleService.modifierSalle(salle);
        return "redirect:/details_batiment?id="+salle.getBatiment().getId();
    }

    @RequestMapping(value = "/supprimer_salle_batiment", method = RequestMethod.POST)
    public String supprimer_salle_batiment(Model model, Salle salle){
        Long id = salle.getBatiment().getId();
        salleService.supprimerSalle(salle);
        return "redirect:/details_batiment?id="+id;
    }
}
