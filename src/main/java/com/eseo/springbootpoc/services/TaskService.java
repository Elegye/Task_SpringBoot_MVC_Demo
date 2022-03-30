package com.eseo.springbootpoc.services;

import com.eseo.springbootpoc.entities.Task;
import com.eseo.springbootpoc.forms.TaskForm;
import com.eseo.springbootpoc.repositories.TaskRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task create(TaskForm taskForm){
        Task task = new Task();
        task.setAssignee(taskForm.getAssignee());
        task.setDescription(taskForm.getDescription());
        task.setDueTo(taskForm.getDueTo());

        // De cette manière on peut directement gérer les champs "cachés" et être certains que tout est pareil.
        task.setCreatedAt(new Date());
        task.setUpdatedAt(null);
        task.setDeletedAt(null);

        // On sauvegarde en base de données et on retourne l'entité créée.
        return taskRepository.save(task);
    }

}
