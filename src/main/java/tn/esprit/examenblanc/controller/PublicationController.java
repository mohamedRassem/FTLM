package tn.esprit.examenblanc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.entity.Publication;
import tn.esprit.examenblanc.service.IEvenementService;
import tn.esprit.examenblanc.service.IPublicationService;

import java.util.List;

@RestController
@RequestMapping("/api/Publications")
@CrossOrigin(origins = "http://localhost:3000")

public class PublicationController {

    @Autowired
    private IPublicationService publicationService;



    @PutMapping("/{id}")
    public ResponseEntity<Publication> updatePublication(@PathVariable Long id, @RequestBody Publication updatedPublication) {
        Publication updated = publicationService.updatePublication(id, updatedPublication);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping
    public List<Publication> getAllPublications() {
        return publicationService.getAllPublications();
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public List<Publication> getPublicationsByUtilisateurId(@PathVariable Long utilisateurId) {
        return publicationService.getPublicationsByUtilisateurId(utilisateurId);
    }

    @GetMapping("/{id}")
    public Publication getPublicationById(@PathVariable Long id) {
        return publicationService.getPublicationById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePublication(@PathVariable Long id) {
        publicationService.deletePublication(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Publication> addPublication(@RequestBody Publication publication) {
        Publication addedPublication = publicationService.addPublication(publication);
        if (addedPublication != null) {
            return new ResponseEntity<>(addedPublication, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Ajoutez d'autres méthodes de contrôleur si nécessaire
}

