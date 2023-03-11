package sn.seck.GestionCliniqueKissi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.seck.GestionCliniqueKissi.Model.Inscription;
import sn.seck.GestionCliniqueKissi.Model.Patient;

@Repository
@EnableJpaRepositories
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {

    @Query(value = "SELECT i FROM Inscription i WHERE i.firstname =:firstname")
    public Inscription findByInscription(@Param("firstname")String firstname);
}

