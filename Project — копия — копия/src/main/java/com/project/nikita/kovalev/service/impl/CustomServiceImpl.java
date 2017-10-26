package com.project.nikita.kovalev.service.impl;

import com.project.nikita.kovalev.entity.Customer;
import com.project.nikita.kovalev.entity.Volunteer;
import com.project.nikita.kovalev.repository.CustomerRepository;
import com.project.nikita.kovalev.repository.VolunteerRepository;
import com.project.nikita.kovalev.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

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

}
