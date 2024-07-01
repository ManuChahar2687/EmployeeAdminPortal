package vw.task.fullstack.employee_admin_portal.service;

import lombok.Data;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import vw.task.fullstack.employee_admin_portal.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<Employee> store=new ArrayList<>();

    public UserService(){
        store.add(new Employee());
//        store.add(new Employee());
//        store.add(new User(UUID.randomUUID().toString(),"KLI MNO","klimno@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"PQR RST","pqrst@gmail.com"));
    }

    public List<Employee> getUsers(){
        return this.store;
    }

}
