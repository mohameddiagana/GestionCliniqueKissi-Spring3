package sn.seck.GestionCliniqueKissi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.seck.GestionCliniqueKissi.Model.Users;
import sn.seck.GestionCliniqueKissi.Repository.UserRepository;

import java.util.List;

public interface UserService {

    Users addNewUser(Users user);

    List<Users> listuser();
        }


