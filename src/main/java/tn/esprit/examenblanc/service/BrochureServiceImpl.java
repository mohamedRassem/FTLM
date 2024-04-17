package tn.esprit.examenblanc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examenblanc.entity.Brochure;
import tn.esprit.examenblanc.entity.Utilisateur;
import tn.esprit.examenblanc.repo.BrochureRepository;

import java.util.List;

@Service
public class BrochureServiceImpl implements IBrochureService {

    @Autowired
    private BrochureRepository brochureRepository;

    @Override
    public Brochure saveBrochure(Brochure brochure) {
        return brochureRepository.save(brochure);
    }

    @Override
    public Brochure getBrochureById(Long id) {
        return brochureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Brochure> getAllBrochures() {
        return brochureRepository.findAll();
    }



    @Override
    public void deleteBrochure(Long id) {
        brochureRepository.deleteById(id);
    }


    @Override
    public Brochure addBrochure(Brochure O) {
        Brochure brochure = brochureRepository.save(O);
        return brochure;
    }


    // Implémentez d'autres méthodes de service si nécessaire
}

