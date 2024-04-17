package tn.esprit.examenblanc.service;

import tn.esprit.examenblanc.entity.Contact;
import tn.esprit.examenblanc.entity.Utilisateur;

import java.util.List;
import java.util.Map;

public interface IUserService {


    public List<Utilisateur> getAllUsers();

    public Utilisateur getUserById(Long id);

    public List<String> getAllUserLocations();
}