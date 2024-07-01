package vw.task.fullstack.employee_admin_portal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;


    private String houseNumber;
    private String streetName;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Address(String houseNumber, String streetName, String city, String state, String zip, String country) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }
}
