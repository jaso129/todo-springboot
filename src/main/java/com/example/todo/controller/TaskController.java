package com.example.todo.controller;


import com.example.todo.model.*;
import com.example.todo.repository.TaskRepository;
import com.example.todo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTask(){
        List<TaskResponseDTO> result = taskService.getAllTasks();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTask(@PathVariable Long id){
        TaskResponseDTO getIdTask = taskService.getTaskById(id);
        return ResponseEntity.ok(getIdTask);
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> addTask(@RequestBody @Valid TaskRequestDTO dto){
        TaskResponseDTO postTask = taskService.createTask(dto);
        return ResponseEntity.ok(postTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @RequestBody @Valid  TaskRequestDTO dto) {
        TaskResponseDTO updatedTask = taskService.updateTask(id, dto);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
