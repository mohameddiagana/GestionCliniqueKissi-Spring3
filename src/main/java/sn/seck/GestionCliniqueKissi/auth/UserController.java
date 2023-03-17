package sn.seck.GestionCliniqueKissi.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Role;
import sn.seck.GestionCliniqueKissi.Model.Users;
import sn.seck.GestionCliniqueKissi.Repository.UserRepository;
import sn.seck.GestionCliniqueKissi.Service.UserService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/auth/")
@CrossOrigin("http://localhost:8080/api/v1/auth/users/liste")
public class UserController {

    @Autowired
    private UserService userService;
    private UserRepository userRepository;



    public UserController(UserService userService, UserRepository userRepository, UserRepository userRepository1, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userService = userService;
        this.userRepository = userRepository;
    }

    /*pour recuperation des users*/
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Users> userList() {
        log.info("Fetching all users{}");
        return userService.listuser( );
        //return userList().stream( ).toList();
    }

    @PostMapping(value = "/users/add")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String addNewUsers(int id, String firstname, String lastname, String email, String password,String role) {//ajout et mise à jour
        Users user = new Users( );
        user.setId(id);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(Role.valueOf(role));


        try {
            userRepository.save(user);
            userRepository.flush( );
            log.info("add user in database{}", user.getFirstname( ));

        } catch (Exception ex) {
            ex.printStackTrace( );

        }
        return "redirect:/api/v1/auth/user/liste";

//        @RequestMapping(value = "/users/delete", method = RequestMethod.GET)
//        public String delete(int id)  {
//            try {
//                userRepository.deleteAllById(id);
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//            return "redirect:/api/v1/auth/user/liste";
//
//
//        }

//    @RequestMapping(value = "/users/edit", method = RequestMethod.GET)
//    public String edit(ModelMap modelmap, int id) {
//        List<Users> user = userRepository.findAll();
//        //List<Role> roles = rolerepository.findAll();
//        model.put("liste_users", user);
////        model.put("list_roles", roles);
//
//        Users u = userRepository.getById(id);
//        model.put("user", user);
//
//        Role r = rolerepository.getById(id);
//        model.put("role", roles);
//
//        return "/user/liste";
//    }


    }
}

