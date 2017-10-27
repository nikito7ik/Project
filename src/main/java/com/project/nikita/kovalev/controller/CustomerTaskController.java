package com.project.nikita.kovalev.controller;

import com.project.nikita.kovalev.entity.CustomerTask;
import com.project.nikita.kovalev.entity.enums.Status;
import com.project.nikita.kovalev.service.CustomerTaskService;
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

    @RequestMapping(value = "/tasks/create/{id}/{title}/{description}/{date}/{address}/{status}", method = RequestMethod.GET)
    @ResponseBody
    public void createCustomerTask(@PathVariable("id") long volunteerTaskID, @PathVariable("title") String title,
                                    @PathVariable("description") String description, @PathVariable("date") String date, @PathVariable("address") String address,
                                    @PathVariable("status") Status status) throws Exception {
        service.createCustomerTask(volunteerTaskID, title, description, date, address, status);
    }

}
