package com.eseo.springbootpoc.controllers;

import com.eseo.springbootpoc.forms.TaskForm;
import com.eseo.springbootpoc.repositories.TaskRepository;
import com.eseo.springbootpoc.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping(value = "/")
    private String index(Model tasks) {

        tasks.addAttribute("tasks", taskRepository.findAll());
        return "index";
    }

    @GetMapping(value = "/task")
    private String create(TaskForm taskForm) {
        return "create";
    }

    @PostMapping(value = "/task")
    private String postTask(@Valid TaskForm taskForm, BindingResult bindingResult, Model model){

        // S'il y a des erreurs, on retourne au formulaire.
        if (bindingResult.hasErrors()) {
            model.addAttribute("form", taskForm);
            return "create";
        }
        else{
            this.taskService.create(taskForm);
        }

        return "redirect:/";
    }

}
