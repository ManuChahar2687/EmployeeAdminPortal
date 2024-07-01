package vw.task.fullstack.employee_admin_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vw.task.fullstack.employee_admin_portal.entity.Employee;
import vw.task.fullstack.employee_admin_portal.repository.EmployeeRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class CustomEmployeeService implements UserDetailsService {

    @Autowired
    private EmployeeRepository empRepo;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return empRepo.findByName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with name : " + username));
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = empRepo.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with name: " + username));


        // Ensure Employee class has necessary fields like username, password, roles
        return new Employee(employee.getEmpId(),employee.getName(), employee.getPassword(),employee.getRole()); // Add roles if needed
    }

}
