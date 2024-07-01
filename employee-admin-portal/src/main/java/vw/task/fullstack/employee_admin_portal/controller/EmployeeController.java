package vw.task.fullstack.employee_admin_portal.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vw.task.fullstack.employee_admin_portal.entity.Employee;
import vw.task.fullstack.employee_admin_portal.service.EmployeeService;

import java.util.List;
import java.util.Optional;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employees")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> empList = employeeService.findAllEmployees();
        if(empList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(empList);
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> emp = employeeService.findEmployeeById(id);
        if(emp.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(emp);
    }

    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.addEmployee(employee);
        if(emp == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(emp);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        if(employeeService.findEmployeeById(id).isPresent()) {
            Employee emp = employeeService.updateEmployee(employee, id);
            return ResponseEntity.ok(emp);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Optional<Employee>> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> emp = employeeService.findEmployeeById(id);
        if(emp.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(emp);
    }
}
