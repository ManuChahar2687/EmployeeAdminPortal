package vw.task.fullstack.employee_admin_portal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long meetingId;

    private String meetingTitle;
    private String meetingDescription;
    private String meetingLocation;
    private String meetingTime;

    public Meeting(String meetingTitle, String meetingDescription, String meetingLocation, String meetingTime) {
        this.meetingTitle = meetingTitle;
        this.meetingDescription = meetingDescription;
        this.meetingLocation = meetingLocation;
        this.meetingTime = meetingTime;
    }
}
