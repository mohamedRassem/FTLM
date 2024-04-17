package tn.esprit.examenblanc.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Brochure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBrochure;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String fichier; // Peut être le chemin vers le fichier ou une référence au fichier dans le système de fichiers




    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;
}

