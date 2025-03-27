package com.example.todo.controller;


import com.example.todo.model.Task;
import com.example.todo.model.TaskRequestDTO;
import com.example.todo.repository.TaskRepository;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }

    @PostMapping
    public String addTask(@RequestBody TaskRequestDTO taskRequestDTO){
        taskService.createTask(taskRequestDTO);
        return "Add task successfully";
    }
}
