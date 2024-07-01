package vw.task.fullstack.employee_admin_portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class EmployeeAdminPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAdminPortalApplication.class, args);
	}

}
