package sn.seck.GestionCliniqueKissi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sn.seck.GestionCliniqueKissi.Model.Patient;
import sn.seck.GestionCliniqueKissi.Model.Role;
import sn.seck.GestionCliniqueKissi.Model.Users;
import sn.seck.GestionCliniqueKissi.Service.PatientService;
import sn.seck.GestionCliniqueKissi.Service.UserService;

import java.util.ArrayList;


@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
@ComponentScan
@ComponentScan(basePackages = {"sn.seck.GestionCliniqueKissi.Service"})
public class GestionCliniqueKissiApplication {

		private UserService userService;
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

	userService.addNewUser(new Users( 1,"moha","diagana","mdiaganaisidk@gmail.com","1234", Role.ADMIN ));
	userService.addNewUser(new Users( 22,"mohamed bocar","samba","assisi@gmail.sn","passer123", Role.USER ));
	userService.addNewUser(new Users( 5,"yacoub","samba","ycb@gmail.sn","passer123", Role.SUPER_ADMIN ));
	userService.addNewUser(new Users( 22,"da bocar","va","assisi@gmail.sn","123", Role.COMPTABLE ));


			patientService.addNewPatient(new Patient(1, 124,"dahaba","tandia ablaye","dbtandia@gmail.com","772512985","male",
					null,"sahm","developpeur",861254587,20));

			patientService.addNewPatient(new Patient(2, 552,"lala","tandia la","lala@gmail.com","772565225","femel",
					null,"police4","commercante",877878444,60));


		};

}
}



