package tn.esprit.examenblanc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenblanc.entity.Contact;
import tn.esprit.examenblanc.service.IContactService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Contacts")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private IContactService contactService;


    @Autowired
    private JavaMailSender javaMailSender;

    private LocalDate eventDate;




    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        Contact updated = contactService.updateContact(id, updatedContact);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all-Contacts")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

    @PostMapping("/add-Contact")
    public ResponseEntity<String> addContact(@RequestBody Contact contact) {
        // Ajouter le contact à la base de données
        Contact savedContact = contactService.addContact(contact);
        // Si le contact est ajouté avec succès, retourner un code de statut 200 (OK)
        return ResponseEntity.ok("Données ajoutées avec succès !");
    }

    @PutMapping("/event-date")
    public ResponseEntity<Void> setEventDate(@RequestBody String eventDateStr) {
        contactService.setEventDate(eventDateStr);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/event-date")
    public ResponseEntity<String> getEventDate() {
        String eventDate = contactService.getEventDate();
        return ResponseEntity.ok(eventDate);
    }


    @GetMapping("/site-visits-statistics")
    public ResponseEntity<Map<String, Integer>> getSiteVisitsStatistics() {
        Map<String, Integer> siteVisitsStatistics = contactService.getSiteVisitsStatistics();
        return ResponseEntity.ok(siteVisitsStatistics);
    }

}










