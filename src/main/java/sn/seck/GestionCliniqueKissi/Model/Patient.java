package sn.seck.GestionCliniqueKissi.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;



@Data
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient",
uniqueConstraints =
@UniqueConstraint(columnNames = "email"))

@EntityListeners(AuditingEntityListener.class)
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpatient;
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
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "datenaissance")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
    @CreatedDate
    private LocalDate datenaissance;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "profession")
    private String profession;
    @Column(name = "cin")
    private int CIN;
    @Column(name = "age")
    private int age;


    public Patient(int idpatient, int codep, String nomp, String prenom, String email, String tel, String sexe, Date datenaissance, String adresse, String profession, String cin, int age) {
    }



}



