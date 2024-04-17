package tn.esprit.examenblanc.service;

import org.springframework.http.ResponseEntity;
import tn.esprit.examenblanc.entity.Contact;
import tn.esprit.examenblanc.entity.Evenement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IContactService {


    Contact getContactById(Long id);

    List<Contact> getAllContacts();


    void deleteContact(Long id);

    public Contact addContact(Contact O);

    public Contact updateContact(Long id, Contact updatedContact);

    void setEventDate(String eventDateStr);
    String getEventDate();

    Map<String, Integer> getSiteVisitsStatistics();
}