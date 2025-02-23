package uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.Repartition.Modele.Repartition;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploisDuTemps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String heure; // Heure du cours
    private String jour; // Jour de la semaine

    private String semaine; // la semaine concerné
    private String semestre; // Semestre concerné

    @ManyToOne
    @JoinColumn(name = "salle_id", nullable = false)
    private Salle salle; // Salle attribuée
    private String groupe; // pour quel groupe on fait l'emploi du temps

    @ManyToOne
    @JoinColumn(name = "repartition_id", nullable = false)
    private Repartition repartition; // Une répartition spécifique (cours/enseignant) liée à cet emploi du temps

}
