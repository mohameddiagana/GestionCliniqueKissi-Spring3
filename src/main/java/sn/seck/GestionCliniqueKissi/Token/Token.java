package sn.seck.GestionCliniqueKissi.Token;

import jakarta.persistence.*;
import lombok.*;
import sn.seck.GestionCliniqueKissi.Model.Users;

@Getter
@Setter
@ToString
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "token")
public class Token {
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;

    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType;

    private Boolean expired;

    private  Boolean revoked;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private Users users;
}
