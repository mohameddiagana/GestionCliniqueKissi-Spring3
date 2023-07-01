package sn.seck.GestionCliniqueKissi.Model;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static sn.seck.GestionCliniqueKissi.Model.Permission.*;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()) ,
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_DELETE,
                    ADMIN_CREATE,
                    ADMIN_UPDATE,

                    MANAGER_READ,
                    MANAGER_CREATE,
                    MANAGER_DELETE,
                    MANAGER_UPDATE


            )
    ),
   MANAGER(
           (
                   Set.of(

                           MANAGER_READ,
                           MANAGER_CREATE,
                           MANAGER_DELETE,
                           MANAGER_UPDATE

                   )
           )
   )
           ;

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> authorities(){
       var authorities =  getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                        .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
       return  authorities;

    }
}

