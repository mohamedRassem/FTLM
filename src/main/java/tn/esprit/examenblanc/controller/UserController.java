package tn.esprit.examenblanc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.entity.Utilisateur;
import tn.esprit.examenblanc.service.IEvenementService;
import tn.esprit.examenblanc.service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private IUserService userService;



    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Utilisateur getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @GetMapping("/locations")
    public List<String> getAllUserLocations() {
        return userService.getAllUserLocations();
    }

}

