package com.project.nikita.kovalev.entity;

import com.project.nikita.kovalev.entity.enums.Status;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "volunteer")
public class Volunteer {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "volunteer_task_volunteer", unique = true)
    private VolunteerTask volunteerTaskVolunteer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_task_volunteer")
    private CustomerTask customerTaskVolunteer;

    public Volunteer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public VolunteerTask getVolunteerTaskVolunteer() {
        return volunteerTaskVolunteer;
    }

    public void setVolunteerTaskVolunteer(VolunteerTask volunteerTaskVolunteer) {
        this.volunteerTaskVolunteer = volunteerTaskVolunteer;
    }

    public CustomerTask getCustomerTaskVolunteer() {
        return customerTaskVolunteer;
    }

    public void setCustomerTaskVolunteer(CustomerTask customerTaskVolunteer) {
        this.customerTaskVolunteer = customerTaskVolunteer;
    }
}
