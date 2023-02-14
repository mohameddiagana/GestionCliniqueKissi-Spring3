package sn.seck.GestionCliniqueKissi.Service;

import org.springframework.stereotype.Service;
import sn.seck.GestionCliniqueKissi.Model.Patient;
import sn.seck.GestionCliniqueKissi.Repository.PatientRepository;

import java.util.List;

public interface PatientService {
    Patient addNewPatient(Patient patient);

    Patient getPatient(String nomp);
    List<Patient> listpatient();



}
