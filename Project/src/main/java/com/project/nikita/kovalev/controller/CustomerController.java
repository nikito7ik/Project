package com.project.nikita.kovalev.controller;

import com.project.nikita.kovalev.entity.Customer;
import com.project.nikita.kovalev.entity.Volunteer;
import com.project.nikita.kovalev.service.CustomerService;
import com.project.nikita.kovalev.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getAllTasks() {
        return service.getAll();
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getTask(@PathVariable("id") long taskID) {
        return service.getByID(taskID);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseBody
    public Customer saveTask(@RequestBody Customer customer) {
        return service.save(customer);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTask(@PathVariable("id") long taskID) {
        service.remove(taskID);
    }
}
