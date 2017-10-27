package com.project.nikita.kovalev.entity;

import com.project.nikita.kovalev.entity.enums.CustomerCategory;
import com.project.nikita.kovalev.entity.enums.Status;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

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

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private CustomerCategory category;

    @OneToOne
    @JoinColumn(name = "customer_task_customer", unique = true)
    private CustomerTask customerTaskCustomer;

    @OneToOne
    @JoinColumn(name = "volunteer_task_customer", unique = true)
    private VolunteerTask volunteerTaskCustomer;

    public Customer() {
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

    public CustomerCategory getCategory() {
        return category;
    }

    public void setCategory(CustomerCategory category) {
        this.category = category;
    }

    public CustomerTask getCustomerTaskCustomer() {
        return customerTaskCustomer;
    }

    public void setCustomerTaskCustomer(CustomerTask customerTaskCustomer) {
        this.customerTaskCustomer = customerTaskCustomer;
    }

    public VolunteerTask getVolunteerTaskCustomer() {
        return volunteerTaskCustomer;
    }

    public void setVolunteerTaskCustomer(VolunteerTask volunteerTaskCustomer) {
        this.volunteerTaskCustomer = volunteerTaskCustomer;
    }
}
