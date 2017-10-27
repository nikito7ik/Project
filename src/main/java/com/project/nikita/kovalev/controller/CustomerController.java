package com.project.nikita.kovalev.controller;

import com.project.nikita.kovalev.entity.Customer;
import com.project.nikita.kovalev.entity.Volunteer;
import com.project.nikita.kovalev.entity.enums.CustomerCategory;
import com.project.nikita.kovalev.service.CustomerService;
import com.project.nikita.kovalev.service.VolunteerService;
import org.hibernate.service.spi.ServiceException;
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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public void createCustomer() throws Exception {
        service.createCustomer(1, "Юра", 100, "+649238765493", CustomerCategory.DEAF);
        service.createCustomer(2, "Ваня", 20, "+978467394633", CustomerCategory.BLIND);
        service.createCustomer(3, "Саша", 64, "+346235635654", CustomerCategory.MUTE);
        service.createCustomer(4, "Маша", 10, "+573438668436", CustomerCategory.WHEELCHAIR);
        service.createCustomer(5, "Виолета", 60, "+568368486438", CustomerCategory.MUTE);
    }
}
