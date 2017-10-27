package com.project.nikita.kovalev.controller;

import com.project.nikita.kovalev.entity.Volunteer;
import com.project.nikita.kovalev.entity.enums.CustomerCategory;
import com.project.nikita.kovalev.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/volunteer")
public class VolunteerController {

    private final VolunteerService service;

    @Autowired
    public VolunteerController(VolunteerService service) {
        this.service = service;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Volunteer> getAllVolunteers() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Volunteer getVolunteer(@PathVariable("id") long volunteerID) {
        return service.getByID(volunteerID);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Volunteer saveVolunteer(@RequestBody Volunteer volunteer) {
        return service.save(volunteer);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteVolunteer(@PathVariable("id") long volunteerID) {
        service.remove(volunteerID);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public void createVolunteer() throws Exception {
        service.createVolunteer(1, "Юля", 32, "+123456987654");
        service.createVolunteer(2, "Миша", 19, "+257468654687");
        service.createVolunteer(3, "Валера", 24, "+754854974954");
        service.createVolunteer(4, "Карина", 25, "+759474067046");
        service.createVolunteer(5, "Артур", 20, "+743643864868");
    }
}
