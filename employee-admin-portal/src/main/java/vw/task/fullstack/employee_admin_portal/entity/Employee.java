package vw.task.fullstack.employee_admin_portal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vw.task.fullstack.employee_admin_portal.entity.Address;
import vw.task.fullstack.employee_admin_portal.entity.Meeting;
import vw.task.fullstack.employee_admin_portal.entity.Department;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    private String name;
    private String phoneNumber;
    private String email;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Address.class, cascade = CascadeType.ALL )
    @JoinColumn(name = "employeeId", referencedColumnName = "empId")
    List<Address> addresses;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Meeting.class, cascade = CascadeType.ALL )
    @JoinColumn(name = "employeeId", referencedColumnName = "empId")
    List<Meeting> meetings;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Department.class, cascade = CascadeType.ALL )
    @JoinColumn(name = "employeeId", referencedColumnName = "empId")
    List<Department> department;

//    @ElementCollection(fetch = FetchType.EAGER)
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Roles.class, cascade = CascadeType.ALL )
    @JoinColumn(name = "employeeId", referencedColumnName = "empId")
    List<Roles> role;

    private String password;

    public Employee(Long empId, String name, String password, List<Roles> role) {
        this.empId=empId;
        this.name = name;
        this.password = password;
        this.role = role;
    }



//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // list of roles[USER,ADMIN]
//        // Collection of SimpGrantedAuthority[roles{ADMIN,USER}]
//        return role.stream().map(roleVar  -> new SimpleGrantedAuthority(roleVar.getRole_name())).toList();
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return this.name;
    }

}
