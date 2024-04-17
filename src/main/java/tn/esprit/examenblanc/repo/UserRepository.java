package tn.esprit.examenblanc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.examenblanc.entity.Evenement;
import tn.esprit.examenblanc.entity.Utilisateur;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Long> {

    @Query("SELECT DISTINCT u.location FROM Utilisateur u WHERE u.location IS NOT NULL")
    List<String> findAllLocations();
}