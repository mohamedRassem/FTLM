package tn.esprit.examenblanc.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Autres attributs de l'utilisateur

    @OneToMany(mappedBy = "utilisateur")
    private List<Accueil> Accueil;

    @OneToMany(mappedBy = "utilisateur")
    private List<Evenement> evenements;



    @OneToMany(mappedBy = "utilisateur")
    private List<Publication> Publication;

    @OneToMany(mappedBy = "utilisateur")
    private List<Webinaire> Webinaire;




    private String location;




}



















