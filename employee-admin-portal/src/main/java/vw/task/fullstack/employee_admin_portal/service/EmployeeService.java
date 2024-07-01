package vw.task.fullstack.employee_admin_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vw.task.fullstack.employee_admin_portal.entity.Employee;
import vw.task.fullstack.employee_admin_portal.entity.Roles;
import vw.task.fullstack.employee_admin_portal.repository.EmployeeRepository;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
//        List<Roles> roleList = employee.getRole();
//        Employee emp = employeeRepository.save(employee);
//        emp.setRole(roleList);
//        return emp;

        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Employee employee, Long id) {
        Optional<Employee> emp = employeeRepository.findById(id);

        if(emp.isPresent()) {
            Employee e = emp.get();
            e.setName(employee.getName());
            e.setEmail(employee.getEmail());
            e.setAddresses(employee.getAddresses());
            e.setPhoneNumber(employee.getPhoneNumber());
            e.setMeetings(employee.getMeetings());
            e.setDepartment(employee.getDepartment());
            return employeeRepository.save(e);
        }
        return employeeRepository.save(employee);
    }

    public Optional<Employee> deleteEmployee(Long id) {
        Optional<Employee> deletedEmp = employeeRepository.findById(id);
        employeeRepository.deleteById(id);
        return  deletedEmp;
    }


}
