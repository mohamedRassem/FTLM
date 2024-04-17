package tn.esprit.examenblanc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examenblanc.entity.Brochure;

import java.util.List;

@Repository
public interface BrochureRepository extends JpaRepository<Brochure, Long> {
    List<Brochure> findByUtilisateurId(Long utilisateurId);
}
