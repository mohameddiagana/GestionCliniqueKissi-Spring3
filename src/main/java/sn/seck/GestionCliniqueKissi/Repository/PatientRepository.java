package sn.seck.GestionCliniqueKissi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.seck.GestionCliniqueKissi.Model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    @Modifying
    @Query(value = "SELECT p FROM Patient p WHERE p.nomp =:nomp")
    public Patient findByPatient(@Param("nomp")String nomp);
}
