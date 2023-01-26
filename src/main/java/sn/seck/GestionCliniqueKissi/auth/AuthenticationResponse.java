package sn.seck.GestionCliniqueKissi.auth;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AuthenticationResponse {

    private String token;
}
