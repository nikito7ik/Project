package com.project.nikita.kovalev.service;

import com.project.nikita.kovalev.entity.Customer;
import com.project.nikita.kovalev.entity.Volunteer;
import com.project.nikita.kovalev.entity.enums.CustomerCategory;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();
    Customer getByID(long id);
    Customer save(Customer customer);
    void remove(long id);
    void createCustomer(long id, String name, int age,
                        String phoneNumber, CustomerCategory category) throws ServiceException;

}
