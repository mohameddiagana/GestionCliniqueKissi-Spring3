package sn.seck.GestionCliniqueKissi.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Patient;
import sn.seck.GestionCliniqueKissi.Repository.PatientRepository;

import java.time.LocalDate;
import java.util.List;

//@CrossOrigin(origins = "*")
@CrossOrigin( "http://localhost:4200/api/v1/auth/patient/liste")
@RestController
@Slf4j
@RequestMapping("/api/v1/auth")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @RequestMapping(value = "/patient/liste")
    public String listpatients(ModelMap map) {
        List<Patient> listpatients = patientRepository.findAll( );
        log.info("Fetching all patients");
        map.addAttribute("list_patients", patientRepository.findAll( ));//Pour la liste
        map.addAttribute("Patient", new Patient( ));//Pour le formulaire
        return "/patient/liste";
    }

    @GetMapping(value = "/patient/handleDeletePatient")
    public String handleDeletePatient(int idpatient) {
        try {
            patientRepository.delete(patientRepository.getById(idpatient));
            log.info("DELETE THE PATIENT !");

        } catch (Exception ex) {
            ex.printStackTrace( );
        }
        return "redirect:/api/v1/auth/patient/liste";
    }

    @RequestMapping(value = "/patient/NouveauPatient",method = RequestMethod.POST)
    public String NouveauPatient(int idpatient, String codep, String nomp, String prenom, String adresse, String email, String tel, String sexe, LocalDate datenaissance, String profession, int CIN, int age) {//ajout et mise à jour
        log.info("Saving New Patient in database{}", patientRepository.findByPatient(nomp));
        Patient patient = new Patient( );
        patient.setIdpatient(idpatient);
        patient.setCodep(codep);
        patient.setNomp(nomp);
        patient.setPrenom(prenom);
        patient.setEmail(email);
        patient.setTel(tel);
        patient.setSexe(sexe);

        patient.setDatenaissance(datenaissance);
        patient.setAdresse(adresse);
        patient.setProfession(profession);
        patient.setCIN(CIN);
        patient.setAge(age);
        try {
            patientRepository.save(patient);
            patientRepository.flush( );

        } catch (Exception ex) {
            ex.printStackTrace( );

        }
        return "redirect:/api/v1/auth/patient/liste";

    }

    @GetMapping(value = "/patient/Editer")
    public String setEdit(ModelMap model, int idpatient) {
        try {
            List<Patient> patientList = patientRepository.findAll();
            log.info("EDIT THE PATIENT !!!");
            model.put("list_patients", patientList);
            Patient patient = patientRepository.getOne(idpatient);
            model.put("patient", patient);

        } catch (Exception ex) {
            ex.printStackTrace( );

        }
        return "redirect:/api/v1/auth/patient/liste";

    }


    @RequestMapping(path = "/patient/update",method = RequestMethod.PUT)
    public String update(@PathVariable int idpatient, @RequestBody Patient patient){
        log.info("UPDATE THE NEW PATIENT !!!");
        patient.setIdpatient(idpatient);
        return "/patient/liste";
    }
}