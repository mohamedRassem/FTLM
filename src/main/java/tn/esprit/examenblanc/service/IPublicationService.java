package tn.esprit.examenblanc.service;

import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.entity.Publication;

import java.util.List;

public interface IPublicationService {



    Publication getPublicationById(Long id);

    List<Publication> getAllPublications();

    List<Publication> getPublicationsByUtilisateurId(Long utilisateurId);

    void deletePublication(Long id);

    Publication addPublication(Publication publication);
    public Publication updatePublication(Long id, Publication updatedPublication);



    // Ajoutez d'autres méthodes de service si nécessaire
}