package sn.seck.GestionCliniqueKissi.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.SerializableString;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import org.hibernate.engine.jdbc.SerializableClobProxy;
import org.springframework.core.serializer.Serializer;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@ToString
@Data
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
    @Column(name = "codep",nullable = false,length = 150)
    private String codep;
    @Column(name = "nomp",nullable = false,length = 150)
    private String nomp;
    @Column(name = "prenom",nullable = false,length = 150)
    private String prenom;
    @Column(name = "email")
    @NotBlank(message = "entrer vos mail")
    @Email(message = "email de dois pas etre null")
    private String email;
    @Column(name = "tel")
    private String tel;
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "datenaissance")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
    @CreatedDate
    private LocalDate datenaissance;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "profession")
    private String profession;
    @Column(name = "CIN")
    private int CIN;
    @Column(name = "age")
    private int age;

//    public int getAge(LocalDate date, Date startDate, Date endDate) {
//        LocalDate maintenant = LocalDate.now();
//        LocalDate dateNaissance;
//
//        return Period.between(datenaissance, maintenant).getYears();
//
//    }



    public Patient(int idpatient, int codep, String nomp, String prenom, String email, String tel, String sexe, LocalDate datenaissance, String adresse, String profession, int CIN, int age) {
    }


}
//        !(date.before(startDate) || date.after(endDate))
//        !date.before(startDate) && !date.after(endDate)
//        return !(startDate != null && date.before(startDate) || endDate != null && date.after(endDate));



