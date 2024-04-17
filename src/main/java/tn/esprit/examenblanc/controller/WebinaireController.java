package tn.esprit.examenblanc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.entity.Webinaire;
import tn.esprit.examenblanc.service.IEvenementService;
import tn.esprit.examenblanc.service.IWebinaireService;

import java.util.List;

@RestController
@RequestMapping("/api/Webinaire")
public class WebinaireController {

    @Autowired
    private IWebinaireService webinaireService;



    @PutMapping("/{id}")
    public ResponseEntity<Webinaire> updateWebinaire(@PathVariable Long id, @RequestBody Webinaire updatedWebinaire) {
        Webinaire updated = webinaireService.updateWebinaire(id, updatedWebinaire);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping
    public List<Webinaire> getAllWebinaires() {
        return webinaireService.getAllWebinaires();
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public List<Webinaire> getWebinairesByUtilisateurId(@PathVariable Long utilisateurId) {
        return webinaireService.getWebinairesByUtilisateurId(utilisateurId);
    }

    @GetMapping("/{id}")
    public Webinaire getWebinaireById(@PathVariable Long id) {
        return webinaireService.getWebinaireById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWebinaire(@PathVariable Long id) {
        webinaireService.deleteWebinaire(id);
    }

    @PostMapping("/add-Webinaire")
    public Webinaire addWebinaire(@RequestBody Webinaire O) {
        Webinaire webinaire = webinaireService.addWebinaire(O);
        return webinaire;
    }

    // Ajoutez d'autres méthodes de contrôleur si nécessaire
}

