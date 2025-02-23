package uasz.sn.Gestion_Enseignement.Projet_Devoir.maquette.Modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.sn.Gestion_Enseignement.Projet_Devoir.Repartition.Modele.Enseignement;

import java.util.Collection;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Maquette {
    //id de la maquette
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    //l'attribut semestre permet de trier les elements a l'affichage pour savoir si c'est au 1er ou 2nd semestre
    private String semestre ;

    //Dans une maquette on peut avoir plusier formation alors que dans une formation peut appartenir a une seule maquette
    @ManyToOne( cascade =  CascadeType.PERSIST)
    private Formation formation;

    //dans une maquette on peut avoir plusieur UE et une UE peut appartenir a plusieur maquette
   /* @ManyToMany( cascade = CascadeType.ALL)
    private Collection<UE> ue;*/
    //@ManyToMany(cascade = {CascadeType.REMOVE})
    /*@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Collection<UE> ue;*/

    @ManyToMany(cascade = {CascadeType.MERGE})
    private Collection<UE> ue;

    @ManyToOne
    private Classe classe;

    //variable boolean pour archiver une maquette
    private boolean archiver ;
    @OneToMany(mappedBy = "maquette")
    private Set<Enseignement> enseignements;


}
