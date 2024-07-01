package vw.task.fullstack.employee_admin_portal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import vw.task.fullstack.employee_admin_portal.entity.Employee;
import vw.task.fullstack.employee_admin_portal.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;

import static org.hamcrest.Matchers.*;
public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks((this));
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    @Order(1)
    void addEmployee_shouldSucceed() throws Exception {
        Employee employee = new Employee();
        employee.setName("Manu Chahar");

        when(employeeService.addEmployee(employee)).thenReturn(employee);
        employeeController.addEmployee(employee);

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employee)))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    void addEmployee_shouldFail_returnBadRequest() throws Exception {
        when(employeeService.addEmployee(any())).thenReturn(null);

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(any())))
                .andExpect(status().isBadRequest());

    }

    @Test
    @Order(3)
    void getAllEmployee_shouldsucceed() throws Exception {
        Employee e1 = new Employee();
        e1.setName("Manu Chahar");
        Employee e2 = new Employee();
        e2.setName("Sahil Chahar");
        List<Employee> emps = new ArrayList<>();
        emps.add(e1);
        emps.add(e2);

        when(employeeService.findAllEmployees()).thenReturn(emps);
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    void getAllEmployee_shouldFail_returnNoContent() throws Exception {
        when(employeeService.findAllEmployees()).thenReturn(List.of());
        mockMvc.perform(get("/employees"))
                .andExpect(status().isNoContent());
    }

    @Test
    @Order(5)
    void getEmployeeById_shouldSucceed() throws Exception {
        Employee e1 = new Employee();
        e1.setEmpId(1L);
        e1.setName("Manu Chahar");
        when(employeeService.findEmployeeById(1L)).thenReturn(Optional.of(e1));
        mockMvc.perform(get("/employees/{id}", e1.getEmpId()))
                .andExpect(status().isOk());
    }

    @Test
    @Order(6)
    void getEmployeeById_shouldFail_return() throws Exception {
        when(employeeService.findEmployeeById(any())).thenReturn(Optional.empty());
        mockMvc.perform(get("/employees/{id}", 1L))
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(7)
    void deleteEmployee_shouldSucceed() throws Exception {
        Employee e1 = new Employee();
        e1.setEmpId(1L);
        e1.setName("Manu Chahar");
        when(employeeService.deleteEmployee(1L)).thenReturn(Optional.of(e1));
        mockMvc.perform(delete("/employees/{id}", 1L ))
                .andExpect(status().isOk());
    }

    @Test
    @Order(8)
    void deleteEmployee_shouldFail_return() throws Exception {
        when(employeeService.deleteEmployee(any())).thenReturn(Optional.empty());
        mockMvc.perform(delete("/employees/{empId}", 1L))
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(9)
    void updateEmployee_shouldSucceed() throws Exception {
        Employee e1 = new Employee();
        e1.setEmpId(1L);
        e1.setName("Manu Chahar");
        Employee e2 = new Employee();
        e2.setEmpId(1L);
        e2.setName("Sahil Chahar");
        when(employeeService.updateEmployee(e2,1L)).thenReturn(e2);
//        Employee updatedEmployee = employeeService.updateEmployee(e2,2L);
        mockMvc.perform(put("/employees/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(e2))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.empName", is("Sahil Chahar")));
    }

//    @Test
//    @Order(10)
//    void updateEmployee_shouldFail_return() throws Exception {
//        when(employeeService.updateEmployee(any(Employee.class),2L)).thenReturn(Optional.empty());
//        mockMvc.perform(put("/employees/{id}", 1L))
//                .andExpect(status().isNotFound());
//    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
