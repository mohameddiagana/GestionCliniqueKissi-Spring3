package sn.seck.GestionCliniqueKissi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sn.seck.GestionCliniqueKissi.Model.Patient;
import sn.seck.GestionCliniqueKissi.Model.Role;
import sn.seck.GestionCliniqueKissi.Model.Users;
import sn.seck.GestionCliniqueKissi.Service.PatientService;
import sn.seck.GestionCliniqueKissi.Service.UserService;

import java.util.ArrayList;


@SpringBootApplication
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

			patientService.addNewPatient(new Patient( null , 1128,"diagana","bocar","mdiaganaisigmail.com","788447568","male"
					, "31/12/1998","sahm","dev",1231770288,25));


		};

}
}



