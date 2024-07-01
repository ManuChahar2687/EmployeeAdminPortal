package vw.task.fullstack.employee_admin_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vw.task.fullstack.employee_admin_portal.entity.Meeting;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer> {
}
