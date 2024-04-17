package tn.esprit.examenblanc.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.examenblanc.entity.Brochure;
import tn.esprit.examenblanc.entity.Utilisateur;

import java.util.List;

public interface IBrochureService {

    Brochure saveBrochure(Brochure brochure);

    Brochure getBrochureById(Long id);

    List<Brochure> getAllBrochures();


    void deleteBrochure(Long id);

    public Brochure addBrochure(Brochure O);




    // Ajoutez d'autres méthodes de service si nécessaire
}

