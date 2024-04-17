package tn.esprit.examenblanc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examenblanc.entity.Contact;
import tn.esprit.examenblanc.entity.Utilisateur;
import tn.esprit.examenblanc.repo.ContactRepository;
import tn.esprit.examenblanc.repo.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public List<Utilisateur> getAllUsers() {
        return userRepository.findAll();
    }

    public Utilisateur getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }



    public List<String> getAllUserLocations() {
        return userRepository.findAllLocations(); // Méthode à ajouter dans UserRepository
    }

}