package sn.seck.GestionCliniqueKissi.Model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

public enum Role {
    USER("USER") ,
    ADMIN("ADMIN"),
    SUPER_ADMIN("SUPER_ADMIN"),
    RH("RH") ,
    COMPTABLE("COMPTABLE");

    private final String name;

    Role(String name){
        this.name = name;
    }

}

