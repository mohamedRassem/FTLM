package tn.esprit.examenblanc.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String fullName;

    @Email
    private String email;

    private Long phoneNumber;

    private String company;

    private String yourMessenger;

    private String eventDateStr;

    private LocalDate visitDate;// Ajout de la date de l'événement

    // Constructeur sans la date de l'événement
    public Contact(Long id, String fullName, String email, Long phoneNumber, String company, String yourMessenger) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.yourMessenger = yourMessenger;
    }


}







