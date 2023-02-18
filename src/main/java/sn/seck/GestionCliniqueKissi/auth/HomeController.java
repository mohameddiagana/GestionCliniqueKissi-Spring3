package sn.seck.GestionCliniqueKissi.auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@Getter
@Setter
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Bonjour, monde!");
        return "home";
        }

        // Ajoutez des autres méthodes pour gérer les autres requêtes
}
