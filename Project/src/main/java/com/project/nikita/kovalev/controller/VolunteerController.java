package com.project.nikita.kovalev.controller;

import com.project.nikita.kovalev.entity.Volunteer;
import com.project.nikita.kovalev.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerService service;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseBody
    public List<Volunteer> getAllTasks() {
        return service.getAll();
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Volunteer getTask(@PathVariable("id") long taskID) {
        return service.getByID(taskID);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseBody
    public Volunteer saveTask(@RequestBody Volunteer volunteer) {
        return service.save(volunteer);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTask(@PathVariable("id") long taskID) {
        service.remove(taskID);
    }
}
