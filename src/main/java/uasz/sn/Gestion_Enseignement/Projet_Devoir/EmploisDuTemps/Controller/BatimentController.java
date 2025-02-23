package uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Modele.Batiment;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Modele.Salle;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Service.BatimentService;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.maquette.Modele.Classe;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.maquette.Modele.Formation;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.maquette.Service.FormationService;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.maquette.Service.MaquetteService;

import java.util.List;

@Controller
public class BatimentController {
    @Autowired
    private BatimentService batimentService;
    @Autowired
    MaquetteService maquetteService;

    @RequestMapping(value = "/batiment", method = RequestMethod.GET)
    public  String lister_batiment(Model model){
        List<Batiment> batimentList = batimentService.afficherToutBatiment();
        model.addAttribute("listeDesBatiments", batimentList);
        return "batiment";
    }

    @RequestMapping(value = "/ajouter_batiment", method = RequestMethod.POST)
    public String ajouter_batiment(Model model, Batiment batiment){
        batimentService.ajouterFormation(batiment);
        return "redirect:/batiment";
    }

    @RequestMapping(value = "/modifier_batiment", method = RequestMethod.POST)
    public String modifier_batiment(Model model, Batiment batiment){
        batimentService.modifierBatiment(batiment);
        return "redirect:/batiment";
    }

    @RequestMapping(value = "/supprimer_batiment", method = RequestMethod.POST)
    public String supprimer_batiment(Model model, Batiment batiment){
        batimentService.supprimerBatiment(batiment);
        return "redirect:/batiment";
    }

    @RequestMapping(value = "/details_batiment", method = RequestMethod.GET)
    public String details_batiment(Model model, @RequestParam("id") Long id){
        Batiment batiment = batimentService.afficherBatiment(id);
        List <Salle> salleList = batimentService.afficherLesSalles(batiment);
        // Ajouter un nouvel objet salle pour le formulaire
        Salle newSalle = new Salle();
        newSalle.setBatiment(batiment); // Associe directement la formation a la nouvelle salle

        model.addAttribute("batiment", batiment);
        model.addAttribute("listeDesSalles", salleList);
        model.addAttribute("newSalle", newSalle); // Objet pour le formulaire
        return "details_batiment";
    }
}
