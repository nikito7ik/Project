package com.project.nikita.kovalev.service;

import com.project.nikita.kovalev.entity.Customer;
import com.project.nikita.kovalev.entity.enums.CustomerCategory;
import com.project.nikita.kovalev.entity.enums.Sex;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();
    Customer getByID(long id);
    Customer save(Customer customer);
    void remove(long id);
    void createCustomer(long id, String name, int age, Sex sex,
                        String phoneNumber, CustomerCategory category) throws ServiceException;

}
