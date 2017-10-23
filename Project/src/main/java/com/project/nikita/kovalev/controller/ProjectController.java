package com.project.nikita.kovalev.controller;

import com.project.nikita.kovalev.entity.Task;
import com.project.nikita.kovalev.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/task")
public class ProjectController {

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Task getTask() {
        List<Task> list = taskRepository.findAll();
        return createMockTask();
    }

    private Task createMockTask() {
        Task task = new Task();
        task.setId(1);
        task.setTitle("NNNiga");
        task.setTaskDate(new Date());
        return task;
    }

}
