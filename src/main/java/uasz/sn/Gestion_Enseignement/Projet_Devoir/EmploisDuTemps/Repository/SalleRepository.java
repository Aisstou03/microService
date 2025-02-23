package uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Modele.Salle;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.maquette.Modele.Formation;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
}
