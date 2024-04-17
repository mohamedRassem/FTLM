package tn.esprit.examenblanc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.entity.Publication;
import tn.esprit.examenblanc.repo.EvenementRepository;
import tn.esprit.examenblanc.repo.PublicationRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PublicationServiceImpl implements IPublicationService {

    @Autowired
    private PublicationRepository publicationRepository;



    @Override
    public Publication getPublicationById(Long id) {
        return publicationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }

    @Override
    public List<Publication> getPublicationsByUtilisateurId(Long utilisateurId) {
        return publicationRepository.findByUtilisateurId(utilisateurId);
    }

    @Override
    public void deletePublication(Long id) {
        publicationRepository.deleteById(id);
    }


    @Override
    public Publication addPublication(Publication publication) {
        return publicationRepository.save(publication); // Utilisation de la méthode save pour l'ajout
    }


    @Transactional
    public Publication updatePublication(Long id, Publication updatedPublication) {
        if (publicationRepository.existsById(id)) {
            updatedPublication.setId(id);
            return publicationRepository.save(updatedPublication);
        }
        return null; // Gérez le cas où l'exercice n'existe pas
    }
    // Implémentez d'autres méthodes de service si nécessaire
}