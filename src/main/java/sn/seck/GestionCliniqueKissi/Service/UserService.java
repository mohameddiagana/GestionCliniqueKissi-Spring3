package sn.seck.GestionCliniqueKissi.Service;

import sn.seck.GestionCliniqueKissi.Model.Users;

import java.util.List;

public interface UserService {

    Users addNewUser(Users user);

    List<Users> listuser();
        }


