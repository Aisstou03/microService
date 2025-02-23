package uasz.sn.Gestion_Enseignement.Projet_Devoir.EmploisDuTemps.Modele;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Batiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String code;
    @JsonManagedReference // Permet de sérialiser les classes associées
    @OneToMany(mappedBy = "batiment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Salle> salles;

}
