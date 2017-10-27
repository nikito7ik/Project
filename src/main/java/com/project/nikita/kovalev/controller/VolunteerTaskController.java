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

    @RequestMapping(value = "/tasks/create", method = RequestMethod.GET)
    @ResponseBody
    public void createVolunteerTask() throws Exception {
        service.createVolunteerTask(1, "��� � ����", "��� �� ����� ��� 3", "2017-10-29 14:30:00",
                "�. ������, ��������� ������", Status.FREE);
        service.createVolunteerTask(2, "��� � ����", "��� � ���� �������", "2017-10-30 18:30:00",
                "�. ������, ��. ������, ��� 34", Status.FREE);
        service.createVolunteerTask(3, "��� � ��������", "��� � �������� ���", "2017-11-03 11:00:00",
                "�. ������, �������� ���", Status.FREE);
        service.createVolunteerTask(4, "��� �� ��������", "��� � ���� ��������", "2017-11-05 10:40:00",
                "�. ������, ���� ��������", Status.FREE);
        service.createVolunteerTask(5, "���� �� ������", "���� ������ ��������� 3 ����", "2017-11-01 15:20:10",
                "�. ������, ���������", Status.FREE);
    }

}
