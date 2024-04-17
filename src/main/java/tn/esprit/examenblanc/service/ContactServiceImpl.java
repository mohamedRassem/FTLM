package tn.esprit.examenblanc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.examenblanc.entity.Contact;
import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.repo.ContactRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ContactServiceImpl implements IContactService {

    @Autowired
    private ContactRepository contactRepository;



    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }


    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }


    @Override
    public Contact addContact(Contact O) {
        Contact contact = contactRepository.save(O);
        return contact;
    }


    @Transactional
    public Contact updateContact(Long id, Contact updatedContact) {
        if (contactRepository.existsById(id)) {
            updatedContact.setId(id);
            return contactRepository.save(updatedContact);
        }
        return null; // Gérez le cas où l'exercice n'existe pas
    }


    @Override
    public String getEventDate() {
        // Dummy implementation, replace with actual logic to retrieve event date from database or other source
        return "2024-03-22T12:00:00"; // Sample date and time in ISO 8601 format
    }


    @Override
    public void setEventDate(String eventDateStr) {
        // Dummy implementation, replace with logic to parse and store event date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime parsedDate = LocalDateTime.parse(eventDateStr, formatter);
        // Logic to store parsedDate or update existing event date in the database
    }

    @Override
    public Map<String, Integer> getSiteVisitsStatistics() {
        // Implémentation pour récupérer les statistiques des visites du site depuis votre base de données
        // Exemple de données fictives
        Map<String, Integer> siteVisits = new HashMap<>();

        return siteVisits;
    }
}