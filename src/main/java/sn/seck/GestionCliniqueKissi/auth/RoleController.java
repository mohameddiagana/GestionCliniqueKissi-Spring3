//
//package sn.seck.GestionCliniqueKissi.auth;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//import sn.seck.GestionCliniqueKissi.Model.Role;
//import sn.seck.GestionCliniqueKissi.Model.Users;
//import sn.seck.GestionCliniqueKissi.Repository.RoleRepository;
//
//import java.util.List;
//
//@Controller
//@Slf4j
//@RequestMapping("/api/v1/auth/")
//@CrossOrigin("http://localhost:8080/api/v1/auth/role/liste")
//
//public class RoleController {
//    @Autowired(required = false)
//    private RoleRepository rolerepository;
//
//    public RoleController(RoleRepository rolerepository) {
//        this.rolerepository = rolerepository;
//    }
//
//    @RequestMapping(value = "/role/liste")
//    public String liste(Model model) {
//        List<Role> role = rolerepository.findAll();
//        log.info("fetching all users!");
//        model.addAttribute("list_roles", rolerepository.findAll());//Pour la liste
//        model.addAttribute("role", role);
//        return "redirect:/api/v1/auth/role/liste";
//    }
//
////    @GetMapping(value = "/role/delete")
////    public String deleteRole(int idrole) {
////        rolerepository.delete(rolerepository.getOne(idrole));
////        return "redirect:/api/v1/auth/role/liste";
////    }
////    public Role addNewrole(@RequestBody Role role){
////        log.info("add role in database{}",role.name());
////        return rolerepository.saveAndFlush(role);
////    }
////
////    @RequestMapping(value = "/role/edit",method = RequestMethod.GET)
////    public String edit(ModelMap model, int idrole) {
////
////        List<Role> roles = rolerepository.findAll();
////        log.info("Edit the role");
////        model.put("list_roles", roles);
////        Role rls = rolerepository.getById(idrole);
////        model.put("role", rls);
////        return "redirect:/api/v1/auth/role/liste";
////
////    }
//
//}
//
