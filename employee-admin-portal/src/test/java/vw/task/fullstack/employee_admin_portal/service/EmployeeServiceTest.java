package vw.task.fullstack.employee_admin_portal.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import vw.task.fullstack.employee_admin_portal.entity.Address;
import vw.task.fullstack.employee_admin_portal.entity.Department;
import vw.task.fullstack.employee_admin_portal.entity.Employee;
import vw.task.fullstack.employee_admin_portal.entity.Meeting;
import vw.task.fullstack.employee_admin_portal.repository.EmployeeRepository;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void addEmployee_shouldSucceed() {
        Employee employee = new Employee();
        employee.setName("Manu Chahar");
        employee.setPhoneNumber("9599142687");
        employee.setEmail("m.chahar2687@gmail.com");
        employee.setAddresses(List.of(
                new Address(101L,"123","ABC","Ghaziabad","Uttar Pradesh","201013","India"),
                new Address(102L,"987","ABC","New Delhi","Delhi","109120","India")
        ));
        employee.setMeetings(List.of(
                new Meeting(101L,"Team Sync","BKM Neaon Daily Sync","Microsoft Teams","9:15 am"),
                new Meeting(102L,"SDC Standup","I-GK-S SDC standup","Microsoft Teams","9:15 am")
        ));
        employee.setDepartment(List.of(
                new Department(101L,"SDC"),
                new Department(102L,"Logistic")
        ));

        when(employeeRepository.save(any())).thenReturn(employee);

        Employee addedEmployee = employeeService.addEmployee(employee);
        assertNotNull(addedEmployee);



    }

    @Test
    @Order(2)
    void addEmployee_shouldFailAndReturnNullObject() {
        Employee emp = null;

        when(employeeRepository.save(any())).thenReturn(any());
        Employee addedEmployee = employeeService.addEmployee(emp);
        assertNull(addedEmployee);

    }

    @Test
    @Order(3)
    void getAllEmployees_shouldSucceed() {
        List<Employee> empList = new ArrayList<Employee>();
        Employee emp = new Employee();
        emp.setName("Manu Chahar");
        Employee emp2 = new Employee();
        emp2.setName("Sahil Chahar");
        empList.add(emp);
        empList.add(emp2);

        when(employeeRepository.findAll()).thenReturn(empList);
        List<Employee> employess = employeeService.findAllEmployees();
        assertNotNull(employess);
    }

    @Test
    @Order(4)
    void getAllEmployees_shouldFailAndReturnNullObject_whenListEmpty() {

        when(employeeRepository.findAll()).thenReturn(null);
        List<Employee> empList = employeeService.findAllEmployees();
        assertNull(empList);
    }

    @Test
    @Order(5)
    void getEmployeeById_shouldSucceed() {
        Employee emp = new Employee();
        emp.setName("Manu Chahar");
        emp.setPhoneNumber("9599142687");

        when(employeeRepository.findById(emp.getEmpId())).thenReturn(Optional.of(emp));
        Optional<Employee> employee = employeeService.findEmployeeById(emp.getEmpId());
        assertNotNull(employee);
    }

    @Test
    @Order(6)
    void getEmployeeById_shouldFailAndReturnNullObject_WhenIdNotFound() {

        when(employeeRepository.findById(any())).thenReturn(null);
        Optional<Employee> employee = employeeService.findEmployeeById(any());
        assertNull(employee);
    }

    @Test
    @Order(7)
    @Disabled
    void updateEmployee_shouldSucceed() {
        Employee emp = new Employee();
        emp.setEmpId(1L);
        emp.setName("Manu Chahar");
        emp.setPhoneNumber("9599142687");
        emp.setEmail("m.chahar2687@gmail.com");
        employeeRepository.save(emp);

        Employee emp1 = new Employee();
        emp1.setEmpId(1L);
        emp1.setName("Manu Chahar");
        emp1.setPhoneNumber("9599142687");
        emp1.setEmail("manuchahar2002@gmail.com");


        when(employeeRepository.save(emp1)).thenReturn(emp1);
        employeeService.updateEmployee(emp1,1L);
        assertEquals("manuchahar2002@gmail.com",emp.getEmail());
    }

    @Test
    @Order(8)
    @Disabled
    void updateEmployee_shouldFailAndReturnNullObject_WhenIdNotFound() {

    }

    @Test
    @Order(9)
    void deleteEmployee_shouldSucceed() {
        Employee emp = new Employee();
        emp.setEmpId(1L);
        emp.setName("Manu Chahar");
        emp.setPhoneNumber("9599142687");
        emp.setEmail("m.chahar2687@gmail.com");

        doNothing().when(employeeRepository).deleteById(1L);
        Optional<Employee> employee = employeeService.deleteEmployee(1L);
        assertNotNull(employee);
    }

    @Test
    @Order(10)
    void deleteEmployee_shouldFailAndReturnNullObject_WhenIdNotFound() {
        doNothing().when(employeeRepository).deleteById(any());
        Optional<Employee> employee = employeeService.findEmployeeById(any());
        assertEquals(Optional.empty(),employee);
    }

}
