package vw.task.fullstack.employee_admin_portal.jwtmodal;

import lombok.*;
import vw.task.fullstack.employee_admin_portal.entity.Roles;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {

    private String jwtToken;
    private String username;
    private List<String> roles;
    private Long empId;
    private String role;
}
