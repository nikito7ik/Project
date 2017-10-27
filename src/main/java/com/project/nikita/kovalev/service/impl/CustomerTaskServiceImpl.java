package com.project.nikita.kovalev.service.impl;

import com.project.nikita.kovalev.entity.CustomerTask;
import com.project.nikita.kovalev.entity.enums.Status;
import com.project.nikita.kovalev.repository.CustomerTaskRepository;
import com.project.nikita.kovalev.service.CustomerTaskService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTaskServiceImpl implements CustomerTaskService {

    private final CustomerTaskRepository repository;

    @Autowired
    public CustomerTaskServiceImpl(CustomerTaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CustomerTask> getAll() {
        return repository.findAll();
    }

    @Override
    public CustomerTask getByID(long id) {
        return repository.findOne(id);
    }

    @Override
    public CustomerTask save(CustomerTask customerTask) {
        return repository.saveAndFlush(customerTask);
    }

    @Override
    public void remove(long id) {
        repository.delete(id);
    }

    @Override
    public void createCustomerTask(long id, String title, String description,
                                    String taskDate, String address, Status status) throws ServiceException {
        CustomerTask customerTask = new CustomerTask();
        customerTask.setId(id);
        customerTask.setTitle(title);
        customerTask.setDescription(description);
        customerTask.setTaskDate(taskDate);
        customerTask.setAddress(address);
        customerTask.setStatus(status);
        save(customerTask);
    }
}
