package vw.task.fullstack.employee_admin_portal.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vw.task.fullstack.employee_admin_portal.entity.Employee;
import vw.task.fullstack.employee_admin_portal.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;



    @GetMapping("/users")
    public List<Employee> getUser(){
        System.out.println("getting users");
        return userService.getUsers();
    }

    @GetMapping("/current-user")
    public String getCurrentUser(Principal principal){
        return principal.getName();
    }

}
