package sn.seck.GestionCliniqueKissi.Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  /*IL GENERE 1 CONSTRUCTEUR ET UN PARAMETRE POUR
CHAQUE CHAMPS NECESSIANT UN TRAITEMENT SPECIAL*/
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),

    MANAGER_CREATE("manager:create"),
    MANAGER_DELETE("manager:delete"),
    MANAGER_UPDATE("manager:update"),
    MANAGER_READ("manager:read");


    @Getter
    private final String permission;
}
