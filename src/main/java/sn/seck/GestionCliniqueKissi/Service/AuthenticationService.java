package sn.seck.GestionCliniqueKissi.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.seck.GestionCliniqueKissi.Model.Role;
import sn.seck.GestionCliniqueKissi.Model.Users;
import sn.seck.GestionCliniqueKissi.Repository.UserRepository;
import sn.seck.GestionCliniqueKissi.auth.AuthenticationRequest;
import sn.seck.GestionCliniqueKissi.auth.AuthenticationResponse;
import sn.seck.GestionCliniqueKissi.auth.RegisterRequest;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

//    private final TokenRepository tokenRepository;
   private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = Users.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

                 userRepository.save(user);
                //var savedUser=
                var jwtToken = jwtService.generateToken(user);
//                saveUserToken(savedUser, jwtToken);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

//    private void saveUserToken(Users users, String jwtToken) {
//        var token = Token.builder()
//                .users(users)
//                .token(jwtToken)
//                .tokenType(TokenType.BEARER)
//                .expired(false)
//                .revoked(false)
//                .build();
//        tokenRepository.save(token);



    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var users = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(users);
//        saveUserToken(users,jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

