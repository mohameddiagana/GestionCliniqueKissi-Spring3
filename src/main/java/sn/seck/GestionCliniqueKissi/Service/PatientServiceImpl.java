package sn.seck.GestionCliniqueKissi.Service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sn.seck.GestionCliniqueKissi.Model.Patient;
import sn.seck.GestionCliniqueKissi.Repository.PatientRepository;

import java.util.List;
@Service
@Transactional
@Slf4j
@CacheConfig(cacheNames = "patients")
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    @ResponseStatus(code = HttpStatus.CREATED)
    public Patient addNewPatient(@RequestBody Patient patient) {
        log.info("Saving new Patient {} to the database", patient.getNomp());
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatient(String nomp) {
        log.info("Fetching patient{}",nomp);
        return patientRepository.findByPatient(nomp);
    }


    @Override
    public List<Patient> listpatient() {
        log.info("Fetching all patient");
        return patientRepository.findAll();
    }
}
