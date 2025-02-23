package uasz.sn.Gestion_Enseignement.Projet_Devoir.maquette.Modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String niveau;
    @ManyToOne
    private Formation formation;
    private String descriptionClasse;

    @Override
    public String toString() {
        return "Classe{" +
                "id=" + id +
                ", niveau='" + niveau + '\'' +
                ", formation=" + (formation != null ? formation.getId() : "null") +
                '}';
    }



}
