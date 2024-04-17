package tn.esprit.examenblanc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examenblanc.entity.Brochure;
import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.entity.Utilisateur;
import tn.esprit.examenblanc.repo.BrochureRepository;
import tn.esprit.examenblanc.repo.EvenementRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EvenementServiceImpl implements IEvenementService {

    @Autowired
    private EvenementRepository evenementRepository;



    @Override
    public Evenement getEvenementById(Long id) {
        return evenementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public List<Evenement> getEvenementsByUtilisateurId(Long utilisateurId) {
        return evenementRepository.findByUtilisateurId(utilisateurId);
    }

    @Override
    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);
    }


    @Override
    public Evenement addEvenement(Evenement O) {
        Evenement evenement = evenementRepository.save(O);
        return evenement;
    }


    @Transactional
    public Evenement updateEvenement(Long id, Evenement updatedEvenement) {
        if (evenementRepository.existsById(id)) {
            updatedEvenement.setId(id);
            return evenementRepository.save(updatedEvenement);
        }
        return null; // Gérez le cas où l'exercice n'existe pas
    }
    // Implémentez d'autres méthodes de service si nécessaire
}