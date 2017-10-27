package com.project.nikita.kovalev.controller;

import com.project.nikita.kovalev.entity.Volunteer;
import com.project.nikita.kovalev.entity.enums.Organization;
import com.project.nikita.kovalev.entity.enums.Sex;
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

    @RequestMapping(value = "/create/{id}/{name}/{age}/{sex}/{number}/{organization}", method = RequestMethod.GET)
    @ResponseBody
    public void createVolunteer(@PathVariable("id") long volunteerID, @PathVariable("name") String name,
                                 @PathVariable("age") int age, @PathVariable("sex") Sex sex, @PathVariable("number") String number,
                                 @PathVariable("organization") Organization organization) throws Exception {
        service.createVolunteer(volunteerID, name, age, sex, number, organization);
    }
}
