package sn.seck.GestionCliniqueKissi.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Patient;
import sn.seck.GestionCliniqueKissi.Repository.PatientRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@Slf4j
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin( "http://localhost:8080/api/v1/patients/liste")
@RestController
@RequestMapping("/api/v1/")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @RequestMapping(value = "/patient/liste")
    @ResponseBody
    public String listpatients(ModelMap map) {
        log.info("Fetching all patients");
        List<Patient> listpatients = patientRepository.findAll();
        map.addAttribute("list_patients", patientRepository.findAll());//Pour la liste
        map.addAttribute("Patient", new Patient());//Pour le formulaire
        return "/patient/liste";
    }

    @GetMapping(value = "/patient/delete")
    public String deletepatient(@PathVariable int idpatient) {
        patientRepository.delete(patientRepository.getOne(idpatient));
        return "redirect:/patient/liste";
    }

    @RequestMapping(value = "/patient/add", method = RequestMethod.POST)
    @ResponseBody
    public String addNewPatient(String nomp, int idpatient) throws ParseException {//ajout et mise à jour
        log.info("Saving New Patient in database {}", patientRepository.findByPatient(nomp));
        Patient patient = new Patient();
        patient.setIdpatient(idpatient);
        patient.setCodep(patient.getCodep());
        patient.setNomp(nomp);
        patient.setPrenom(patient.getPrenom( ));
        patient.setEmail(patient.getEmail());
        patient.setTel(patient.getTel());
        patient.setSexe(patient.getSexe());
        patient.setDatenaissance(patient.getDatenaissance());
        patient.setProfession(patient.getProfession( ));
        patient.setCIN(patient.getCIN());
        patient.setAge(patient.getAge());

        patientRepository.saveAndFlush(patient);

        return "redirect:/patient/liste";
    }



    @RequestMapping(value = "/patient/edit", method = RequestMethod.GET)
    public String edit(ModelMap model, int idpatient) {
        log.info("Edit the new patient!");
        List<Patient> patients = patientRepository.findAll();
        model.put("list_patients", patients);
        Patient pts = patientRepository.getById(idpatient);
        model.put("patient", pts);
        return "/patient/liste";
    }
    @RequestMapping(path = "/patient/update",method = RequestMethod.PUT)
    public String update(@PathVariable int idpatient, @RequestBody Patient patient){
        log.info("UPDATE THE NEW PATIENT !!!");
        patient.setIdpatient(idpatient);
        return "/patient/liste";
    }
}
