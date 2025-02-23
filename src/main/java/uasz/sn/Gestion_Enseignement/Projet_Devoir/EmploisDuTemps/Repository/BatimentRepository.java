package uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Modele.Batiment;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Modele.Salle;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.maquette.Modele.Classe;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.maquette.Modele.Formation;

import java.util.List;

@Repository
public interface BatimentRepository extends JpaRepository<Batiment, Long> {
    @Query("SELECT s FROM Salle s WHERE s.batiment = ?1")
    List<Salle> findByBatiment (Batiment batiment);

}
