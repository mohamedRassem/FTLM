package tn.esprit.examenblanc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenblanc.entity.Brochure;
import tn.esprit.examenblanc.entity.Utilisateur;
import tn.esprit.examenblanc.service.IBrochureService;

import java.util.List;

@RestController
@RequestMapping("/api/brochures")
public class BrochureController {

    @Autowired
    private IBrochureService brochureService;



    @PutMapping("/{id}")
    public Brochure updateBrochure(@PathVariable Long id, @RequestBody Brochure updatedBrochure) {
        Brochure existingBrochure = brochureService.getBrochureById(id);

        if (existingBrochure != null) {
            // Mettez à jour les champs nécessaires
            existingBrochure.setTitre(updatedBrochure.getTitre());
            existingBrochure.setDescription(updatedBrochure.getDescription());
            existingBrochure.setFichier(updatedBrochure.getFichier());

            // Enregistrez la brochure mise à jour
            return brochureService.saveBrochure(existingBrochure);
        } else {
            // Gérez le cas où la brochure avec l'ID donné n'existe pas
            // Vous pouvez lancer une exception ou retourner null, selon votre logique métier
            return null;
        }
    }


    @GetMapping
    public List<Brochure> getAllBrochures() {
        return brochureService.getAllBrochures();
    }



    @GetMapping("/{id}")
    public Brochure getBrochureById(@PathVariable Long id) {
        return brochureService.getBrochureById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBrochure(@PathVariable Long id) {
        brochureService.deleteBrochure(id);
    }

    @PostMapping("/add-Brochure")
    public Brochure addBrochure(@RequestBody Brochure O) {
        Brochure brochure = brochureService.addBrochure(O);
        return brochure;
    }

    // Ajoutez d'autres méthodes de contrôleur si nécessaire
}

