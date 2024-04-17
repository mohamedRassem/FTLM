package tn.esprit.examenblanc.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.examenblanc.entity.Brochure;
import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.entity.Utilisateur;

import java.util.List;

public interface IEvenementService {



    Evenement getEvenementById(Long id);

    List<Evenement> getAllEvenements();

    List<Evenement> getEvenementsByUtilisateurId(Long utilisateurId);

    void deleteEvenement(Long id);

    public Evenement addEvenement(Evenement O);

    public Evenement updateEvenement(Long id, Evenement updatedEvenement);



    // Ajoutez d'autres méthodes de service si nécessaire
}