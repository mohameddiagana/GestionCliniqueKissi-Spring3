package sn.seck.GestionCliniqueKissi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sn.seck.GestionCliniqueKissi.Model.Patient;
import sn.seck.GestionCliniqueKissi.Model.Role;
import sn.seck.GestionCliniqueKissi.Model.Users;
import sn.seck.GestionCliniqueKissi.Service.PatientService;
import sn.seck.GestionCliniqueKissi.Service.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication()
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"sn.seck.GestionCliniqueKissi.Service"})
@EnableJpaRepositories(value = "sn.seck.GestionCliniqueKissi.Repository")

@ComponentScan(basePackages = "sn.seck.GestionCliniqueKissi.Model.Users")


public class GestionCliniqueKissiApplication {
		@Autowired
		private UserService userService;
		@Autowired
		private PatientService patientService;

	public GestionCliniqueKissiApplication(UserService userService, PatientService patientService) {
		this.userService = userService;
		this.patientService = patientService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionCliniqueKissiApplication.class, args);
	}

	@Bean
	CommandLineRunner start( ) {
		return args -> {


			LocalDate date = LocalDate.now();
			// Formater la date dans un format spécifique
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dateFormatted = date.format(formatter);

			// Afficher la date dans la console
			System.out.println("La date d'aujourd'hui est: " + dateFormatted);


			userService.addNewUser(new Users( 1,"moha","diagana","mdiaganaisidk@gmail.com","1234", Role.ADMIN ));
	userService.addNewUser(new Users( 2,"mohamed bocar","samba","assisi@gmail.sn","passer123", Role.USER ));
	userService.addNewUser(new Users( 3,"yacoub","samba","ycb@gmail.sn","passer123", Role.SUPER_ADMIN ));
	userService.addNewUser(new Users( 4,"da bocar","va","yassine@gmail.sn","123", Role.RH ));

//			patientService.addNewPatient(new Patient(1, "c124", "dahaba", "tandia ablaye", "dbtandia@gmail.com", "772512985", "homme",
//					LocalDate.now(), "sahm", "developpeur", 861254587, 20));
//
			patientService.addNewPatient(new Patient(2, "c552","lala","tandia la","lala@gmail.com","772565225","femme",
					LocalDate.now(),"police4","commercante",877878444,60));

			patientService.addNewPatient(new Patient(3, "c500","dada","daba tal",
					"taldab@gmail.com","781454748","femme",
					LocalDate.now(),"diourbelle","developpeuse",548852418,56));

//			patientService.addNewPatient(new Patient(4, "c650"," diop","homme",
//					"mame@gmail.com","782156844","femme",
//					LocalDate.now(),"castor","agriculeur",128621125,80));
//
//			patientService.addNewPatient(new Patient(5, "c500","cheik","diagana ba",
//					"ba@gmail.com","78225874","homme",
//					LocalDate.now(),"mbacke","eboueur",877878444,50));
////
//			patientService.addNewPatient(new Patient(6, "c126","cheik","camara cheikh",
//					"camara@gmail.com","7855877","homme",
//					LocalDate.now(),"kzar","developpeur",877878478,100));






		};

}
}



