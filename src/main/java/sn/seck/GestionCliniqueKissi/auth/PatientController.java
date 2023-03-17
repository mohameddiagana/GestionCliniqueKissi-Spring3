package sn.seck.GestionCliniqueKissi.auth;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Patient;
import sn.seck.GestionCliniqueKissi.Repository.PatientRepository;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin( "http://localhost:8080/api/v1/auth/patient/liste")
@Controller
@Slf4j
@RequestMapping("/api/v1/auth")
public class PatientController {

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

    @GetMapping(value = "/patient/delete")
    public String deletepatient(int idpatient) {
        try {
            patientRepository.delete(patientRepository.getById(idpatient));
            log.info("DELETE THE PATIENT !");

        } catch (Exception ex) {
            ex.printStackTrace( );
        }
        return "redirect:/api/v1/auth/patient/liste";
    }

    @RequestMapping(value = "/patient/add",method = RequestMethod.POST)
    public String addNewPatient(int idpatient, String codep, String nomp, String prenom, String adresse, String email, String tel, String sexe, LocalDate datenaissance, String profession, int CIN, int age) {//ajout et mise à jour
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

    @RequestMapping(value ="/patient/edit/",method = RequestMethod.GET)
    public String edit(Model model,  int idpatient) throws Exception {
            List<Patient> patientList = patientRepository.findAll();
            log.info("EDIT THE PATIENT !!!");
            model.addAttribute("list_patients", patientList);
            Patient patient = patientRepository.getOne(idpatient);
            model.addAttribute("patient", patient);

        return "redirect:/api/v1/auth/patient/liste";

    }



    @RequestMapping(path = "/patient/update",method = RequestMethod.PUT)
    public String update(@PathVariable int idpatient, @RequestBody Patient patient){
        log.info("UPDATE THE NEW PATIENT !!!");
        patient.setIdpatient(idpatient);
        return "/patient/liste";
    }
}
