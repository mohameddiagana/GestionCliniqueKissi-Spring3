package sn.seck.GestionCliniqueKissi.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/democontroller")
public class DemoController{
    public ResponseEntity<String> Hellodiaganaspring() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }
}
