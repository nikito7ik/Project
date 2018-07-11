package com.project.nikita.kovalev.controller;

import com.project.nikita.kovalev.entity.Customer;
import com.project.nikita.kovalev.entity.enums.CustomerCategory;
import com.project.nikita.kovalev.entity.enums.Sex;
import com.project.nikita.kovalev.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getAllCustomers() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomer(@PathVariable("id") long customerID) {
        return service.getByID(customerID);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Customer saveCustomer(@RequestBody Customer customer) {
        return service.save(customer);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCustomer(@PathVariable("id") long customerID) {
        service.remove(customerID);
    }

    @RequestMapping(value = "/create/{id}/{name}/{age}/{sex}/{number}/{category}", method = RequestMethod.GET)
    @ResponseBody
    public void createCustomer(@PathVariable("id") long customerID, @PathVariable("name") String name,
                                @PathVariable("age") int age, @PathVariable("sex") Sex sex, @PathVariable("number") String number,
                                @PathVariable("category") CustomerCategory category) throws Exception {
        service.createCustomer(customerID, name, age, sex, number, category);
    }
}
