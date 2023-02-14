package sn.Hospitalkissi.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Users;
import sn.seck.GestionCliniqueKissi.Service.UserService;


import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/users")
@CrossOrigin("http://localhost:8080/api/v1/users")
public class UserController {

   @Autowired
    private UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }


    /*pour recuperation des users*/
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<Users> userList(){
        log.info("Fetching all users{}");
        return userService.listuser();
    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public Users addNewUser(@RequestBody Users user){
        log.info("add user in database{}",user.getUsername());
        return userService.addNewUser(user);
    }

 }

