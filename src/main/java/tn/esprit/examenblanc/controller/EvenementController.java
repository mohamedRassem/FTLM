package tn.esprit.examenblanc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenblanc.entity.Brochure;
import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.entity.Utilisateur;
import tn.esprit.examenblanc.service.IBrochureService;
import tn.esprit.examenblanc.service.IEvenementService;

import java.util.List;

@RestController
@RequestMapping("/api/Evenements")
public class EvenementController {

    @Autowired
    private IEvenementService evenementService;



    @PutMapping("/{id}")
    public ResponseEntity<Evenement> updateEvenement(@PathVariable Long id, @RequestBody Evenement updatedEvenement) {
        Evenement updated = evenementService.updateEvenement(id, updatedEvenement);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping
    public List<Evenement> getAllEvenements() {
        return evenementService.getAllEvenements();
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public List<Evenement> getEvenementsByUtilisateurId(@PathVariable Long utilisateurId) {
        return evenementService.getEvenementsByUtilisateurId(utilisateurId);
    }

    @GetMapping("/{id}")
    public Evenement getEvenementById(@PathVariable Long id) {
        return evenementService.getEvenementById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEvenement(@PathVariable Long id) {
        evenementService.deleteEvenement(id);
    }

    @PostMapping("/add-Evenement")
    public Evenement addEvenement(@RequestBody Evenement O) {
        Evenement evenement = evenementService.addEvenement(O);
        return evenement;
    }

    // Ajoutez d'autres méthodes de contrôleur si nécessaire
}

