package uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Modele;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Modele.Batiment;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Integer numero;
    @JsonBackReference // Empêche la sérialisation récursive de `Formation`
    @ManyToOne
    private Batiment batiment;

    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmploisDuTemps> emploisDuTemps; // Une salle peut accueillir plusieurs emplois du temps

}