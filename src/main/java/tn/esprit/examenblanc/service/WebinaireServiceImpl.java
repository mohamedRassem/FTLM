package tn.esprit.examenblanc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.entity.Webinaire;
import tn.esprit.examenblanc.repo.EvenementRepository;
import tn.esprit.examenblanc.repo.WebinaireRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WebinaireServiceImpl implements IWebinaireService {

    @Autowired
    private WebinaireRepository webinaireRepository;



    @Override
    public Webinaire getWebinaireById(Long id) {
        return webinaireRepository.findById(id).orElse(null);
    }

    @Override
    public List<Webinaire> getAllWebinaires() {
        return webinaireRepository.findAll();
    }

    @Override
    public List<Webinaire> getWebinairesByUtilisateurId(Long utilisateurId) {
        return webinaireRepository.findByUtilisateurId(utilisateurId);
    }

    @Override
    public void deleteWebinaire(Long id) {
        webinaireRepository.deleteById(id);
    }


    @Override
    public Webinaire addWebinaire(Webinaire O) {
        Webinaire webinaire = webinaireRepository.save(O);
        return webinaire;
    }


    @Transactional
    public Webinaire updateWebinaire(Long id, Webinaire updatedWebinaire) {
        if (webinaireRepository.existsById(id)) {
            updatedWebinaire.setId(id);
            return webinaireRepository.save(updatedWebinaire);
        }
        return null; // Gérez le cas où l'exercice n'existe pas
    }
    // Implémentez d'autres méthodes de service si nécessaire
}