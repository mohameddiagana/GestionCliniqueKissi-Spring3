package sn.seck.GestionCliniqueKissi.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient",
uniqueConstraints =
@UniqueConstraint(columnNames = "email"))

public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpatient;
    @Column(name = "codep")
    private int codep;
    @Column(name = "nomp")
    private String nomp;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    @Email(message = "email de dois pas etre null")
    private String email;
    @Column(name = "tel")
    private String tel;
    @Column(name = "sexe", length = 100)
    private String sexe;
    @Column(name = "datenaissance", length = 100)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    @DateTimeFormat( pattern = "yyyy-MM-dd")
//    @NotNull(message = "Date ne doit pas etre null")
//    @Past(message = "Invalide Date")
    private Date datenaissance;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "profession")
    private String profession;
    @Column(name = "cin")
    private int CIN;
    @Column(name = "age")
    private int age;


    public Patient(Long idpatient, int codep, String diagana, String bocar, String email, String tel, String male, String s, String sahm, String dev, int cin, int age) {
    }
}

