package vw.task.fullstack.employee_admin_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vw.task.fullstack.employee_admin_portal.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
