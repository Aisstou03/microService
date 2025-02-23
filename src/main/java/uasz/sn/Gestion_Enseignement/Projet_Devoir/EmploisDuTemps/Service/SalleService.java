package uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Modele.Salle;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Repository.SalleRepository;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.maquette.Modele.Classe;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.maquette.Repository.ClasseRepository;

import java.util.List;

@Service
@Transactional
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;

    public void ajouterSalle(Salle salle){
        salleRepository.save(salle);
    }

    public List<Salle> afficherToutSalle(){
        return salleRepository.findAll();
    }

    public Salle afficherClasse(Long id){
        return salleRepository.getById(id);
    }

    public void modifierSalle(Salle salle){
        Salle salleUpdate=salleRepository.getById(salle.getId());
        salleUpdate.setCode((salle.getCode()));
        salleUpdate.setNumero((salle.getNumero()));
        salleRepository.save(salleUpdate);
    }

    public void supprimerSalle(Salle salle){
        salleRepository.delete(salle);
    }

}
