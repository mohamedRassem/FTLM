package tn.esprit.examenblanc.service;

import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.entity.Webinaire;

import java.util.List;

public interface IWebinaireService {



    Webinaire getWebinaireById(Long id);

    List<Webinaire> getAllWebinaires();

    List<Webinaire> getWebinairesByUtilisateurId(Long utilisateurId);

    void deleteWebinaire(Long id);

    public Webinaire addWebinaire(Webinaire O);

    public Webinaire updateWebinaire(Long id, Webinaire updatedWebinaire);




    // Ajoutez d'autres méthodes de service si nécessaire
}