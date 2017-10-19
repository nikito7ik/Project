package com.project.nikita.kovalev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/task")
public class ProjectController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getTask(ModelMap model) {
        return "My task";
    }

}
