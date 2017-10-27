package com.project.nikita.kovalev.service.impl;

import com.project.nikita.kovalev.entity.Customer;
import com.project.nikita.kovalev.entity.enums.CustomerCategory;
import com.project.nikita.kovalev.entity.enums.Sex;
import com.project.nikita.kovalev.repository.CustomerRepository;
import com.project.nikita.kovalev.service.CustomerService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> getAll() {
            return repository.findAll();
    }

    @Override
    public Customer getByID(long id) {
        return repository.findOne(id);
    }

    @Override
    public Customer save(Customer customer) {
        return repository.saveAndFlush(customer);
    }

    @Override
    public void remove(long id) {
        repository.delete(id);
    }

    @Override
    public void createCustomer(long id, String name, int age, Sex sex,
                               String phoneNumber, CustomerCategory category) throws ServiceException {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setAge(age);
        customer.setSex(sex);
        customer.setPhoneNumber(phoneNumber);
        customer.setCategory(category);
        save(customer);
    }

}
