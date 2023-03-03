package sn.seck.GestionCliniqueKissi.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Patient;
import sn.seck.GestionCliniqueKissi.Repository.PatientRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@CrossOrigin( "http://localhost:8080/api/v1/auth/patient/liste")
@Controller
@RequestMapping("/api/v1/auth")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @RequestMapping(value = "/patient/liste")
    public String listpatients(ModelMap map) {
        List<Patient> listpatients = patientRepository.findAll();
        log.info("Fetching all patients");
        map.addAttribute("list_patients", patientRepository.findAll());//Pour la liste
        map.addAttribute("Patient", new Patient());//Pour le formulaire
        //return listpatients.toString();
        return "/patient/liste";
    }

    @GetMapping(value = "/patient/delete")
    public String deletepatient( int idpatient) {
        try {
            patientRepository.delete(patientRepository.getOne(idpatient));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/api/v1/auth/patient/liste";
    }

    @RequestMapping(value = "/patient/add", method = RequestMethod.POST)
    @ResponseBody
    public String addNewPatient(int idpatient, String codep,String nomp,String prenom, String email,String tel,String sexe,LocalDate datenaissance,String profession,int CIN,int age ) throws Exception {//ajout et mise à jour
        log.info("Saving New Patient in database {}", patientRepository.findByPatient(nomp));
        Patient patient = new Patient();
        patient.setIdpatient(idpatient);
        patient.setCodep(codep);
        patient.setNomp(nomp);
        patient.setPrenom(prenom);
        patient.setEmail(email);
        patient.setTel(tel);
        patient.setSexe(sexe);

        patient.setDatenaissance(datenaissance);
        patient.setProfession(profession);
        patient.setCIN(CIN);
        patient.setAge(age);
        patientRepository.save(patient);

        return "redirect:/api/v1/auth/patient/liste";
    }

    @RequestMapping(value = "/patient/edit", method = RequestMethod.GET)
    public String edit(ModelMap model, int idpatient)throws Exception {
        List<Patient> patients = patientRepository.findAll();
        log.info("Edit the new patient!");

        model.put("list_patients", patients);
        Patient pts = patientRepository.getById(idpatient);
        model.put("patient", pts);
        return "redirect:/api/v1/auth/patient/liste";

    }
//    @RequestMapping(path = "/patient/update",method = RequestMethod.PUT)
//    public String update(@PathVariable int idpatient, @RequestBody Patient patient){
//        log.info("UPDATE THE NEW PATIENT !!!");
//        patient.setIdpatient(idpatient);
//        return "/patient/liste";
//    }
}
