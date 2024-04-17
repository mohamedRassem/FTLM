package tn.esprit.examenblanc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.entity.Publication;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findByUtilisateurId(Long utilisateurId);
}