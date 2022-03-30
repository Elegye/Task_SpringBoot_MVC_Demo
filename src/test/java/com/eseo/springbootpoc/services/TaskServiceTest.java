package com.eseo.springbootpoc.services;

import com.eseo.springbootpoc.entities.Task;
import com.eseo.springbootpoc.forms.TaskForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Test
    @Transactional
    public void shouldSaveToDatabase(){

        TaskForm taskForm = new TaskForm();
        taskForm.setAssignee("Sheldon Cooper");
        taskForm.setDescription("Mettre son pantalon de bus");
        taskForm.setDueTo(new Date());

        Task task = taskService.create(taskForm);


        assertNotNull(task.getId());
        assertEquals("Sheldon Cooper", task.getAssignee());
        assertEquals("Mettre son pantalon de bus", task.getDescription());
        assertEquals(null, task.getUpdatedAt());
        assertEquals(null, task.getUpdatedAt());

    }
}