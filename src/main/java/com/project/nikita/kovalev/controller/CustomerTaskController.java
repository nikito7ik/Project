package com.project.nikita.kovalev.controller;

import com.project.nikita.kovalev.entity.CustomerTask;
import com.project.nikita.kovalev.entity.enums.Status;
import com.project.nikita.kovalev.service.CustomerTaskService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerTaskController {

    private final CustomerTaskService service;

    @Autowired
    public CustomerTaskController(CustomerTaskService service) {
        this.service = service;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseBody
    public List<CustomerTask> getAllTasks() {
        return service.getAll();
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CustomerTask getTask(@PathVariable("id") long taskID) {
        return service.getByID(taskID);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseBody
    public CustomerTask saveTask(@RequestBody CustomerTask customerTask) {
        return service.save(customerTask);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTask(@PathVariable("id") long taskID) {
        service.remove(taskID);
    }

    @RequestMapping(value = "/tasks/create", method = RequestMethod.GET)
    @ResponseBody
    public void createCustomerTask() throws Exception {
        service.createCustomerTask(1, "���� � ����", "���� � ���� �������", "2017-10-30 18:30:00",
                "�. ������, ��. ������, ��� 34", Status.FREE);
        service.createCustomerTask(2, "���� ������ �� ������", "���� ������ ������ ��������� 3 ����", "2017-11-01 15:20:10",
                "�. ������, ���������", Status.FREE);
        service.createCustomerTask(3, "���� � ��������", "���� � �������� ���", "2017-11-03 11:00:00",
                "�. ������, �������� ���", Status.FREE);
        service.createCustomerTask(4, "���� �� ��������", "���� � ���� ��������", "2017-11-05 10:40:00",
                "�. ������, ���� ��������", Status.FREE);
        service.createCustomerTask(5, "���� � ����", "���� �� ����� ��� 3", "2017-10-29 14:30:00",
                "�. ������, ��������� ������", Status.FREE);
    }

}
