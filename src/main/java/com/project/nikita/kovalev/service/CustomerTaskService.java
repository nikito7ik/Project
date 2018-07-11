package com.project.nikita.kovalev.service;

import com.project.nikita.kovalev.entity.CustomerTask;
import com.project.nikita.kovalev.entity.enums.Status;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface CustomerTaskService {

    List<CustomerTask> getAll();
    CustomerTask getByID(long id);
    CustomerTask save(CustomerTask customerTask);
    void remove(long id);
    void createCustomerTask(long id, String title, String description, String taskDate,
                             String address, Status status) throws ServiceException;

}
