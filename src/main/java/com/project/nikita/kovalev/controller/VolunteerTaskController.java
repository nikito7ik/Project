package com.project.nikita.kovalev.controller;

import com.project.nikita.kovalev.entity.VolunteerTask;
import com.project.nikita.kovalev.entity.enums.Status;
import com.project.nikita.kovalev.service.VolunteerTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/volunteer")
public class VolunteerTaskController {

    private final VolunteerTaskService service;

    @Autowired
    public VolunteerTaskController(VolunteerTaskService service) {
        this.service = service;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseBody
    public List<VolunteerTask> getAllTasks() {
        return service.getAll();
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseBody
    public VolunteerTask getTask(@PathVariable("id") long taskID) {
        return service.getByID(taskID);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseBody
    public VolunteerTask saveTask(@RequestBody VolunteerTask volunteerTask) {
        return service.save(volunteerTask);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTask(@PathVariable("id") long taskID) {
        service.remove(taskID);
    }

    @RequestMapping(value = "/tasks/create/{id}/{title}/{description}/{date}/{address}/{car}/{status}", method = RequestMethod.GET)
    @ResponseBody
    public void createVolunteerTask(@PathVariable("id") long volunteerTaskID, @PathVariable("title") String title,
                                @PathVariable("description") String description, @PathVariable("date") String date,
                                    @PathVariable("address") String address, @PathVariable("car") boolean car,
                                @PathVariable("status") Status status) throws Exception {
        service.createVolunteerTask(volunteerTaskID, title, description, date, address, car, status);
    }

}
