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
        service.createVolunteerTask(1, "Иду в кино", "Иду на фильм Тор 3", "2017-10-29 14:30:00",
                "г. Гродно, кинотеатр Космос", Status.FREE);
        service.createVolunteerTask(2, "Иду в кафе", "Иду в кафе Роскоша", "2017-10-30 18:30:00",
                "г. Гродно, ул. Ленина, дом 34", Status.FREE);
        service.createVolunteerTask(3, "Иду в аквапарк", "Иду в аквапарк Фок", "2017-11-03 11:00:00",
                "г. Гродно, Аквапарк Фок", Status.FREE);
        service.createVolunteerTask(4, "Иду на прогулку", "Иду в парк Жилебера", "2017-11-05 10:40:00",
                "г. Гродно, Парк Жилебера", Status.FREE);
        service.createVolunteerTask(5, "Езжу по городу", "Езжу вокруг Советской 3 часа", "2017-11-01 15:20:10",
                "г. Гродно, Советская", Status.FREE);
    }

}
