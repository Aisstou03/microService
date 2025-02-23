package uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Modele.Batiment;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Modele.Salle;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Repository.BatimentRepository;

import java.util.List;

@Service
@Transactional
public class BatimentService {
    @Autowired
    private BatimentRepository batimentRepository;

    public void ajouterFormation(Batiment batiment){
        batimentRepository.save(batiment);
    }

    public List<Batiment> afficherToutBatiment(){
        return batimentRepository.findAll();
    }


    public Batiment afficherBatiment(Long id){
        return batimentRepository.getById(id);
    }

    public void modifierBatiment(Batiment batiment){
        Batiment batimentUpdate=batimentRepository.getById(batiment.getId());
        batimentUpdate.setCode((batiment.getCode()));
        batimentUpdate.setCode((batiment.getCode()));

        batimentUpdate.setNom((batiment.getNom()));
        batimentRepository.save(batimentUpdate);
    }

    public void supprimerBatiment(Batiment batiment){
        batimentRepository.delete(batiment);
    }

    public List<Salle> afficherLesSalles(Batiment batiment){
        return batimentRepository.findByBatiment(batiment);
    }
}
