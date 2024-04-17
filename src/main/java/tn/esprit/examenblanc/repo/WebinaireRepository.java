package tn.esprit.examenblanc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.entity.Webinaire;

import java.util.List;

@Repository
public interface WebinaireRepository extends JpaRepository<Webinaire, Long> {
    List<Webinaire> findByUtilisateurId(Long utilisateurId);
}