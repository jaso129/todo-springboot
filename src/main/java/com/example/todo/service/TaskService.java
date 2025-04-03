package com.example.todo.service;

import com.example.todo.exception.TaskNotFoundException;
import com.example.todo.model.*;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskResponseDTO> getAllTasks(){
        return taskRepository.findAll().stream()
                .map(TaskResponseDTO::fromEntity)
                .toList();
    }

    public TaskResponseDTO getTaskById(Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        return TaskResponseDTO.fromEntity(task);
    }

    public TaskResponseDTO createTask(TaskRequestDTO dto){
        Task task = new Task();
        task.setTitle(dto.getTitle());
        taskRepository.save(task);
        return TaskResponseDTO.fromEntity(task);
    }

    public TaskResponseDTO updateTask(Long id, TaskRequestDTO dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        task.setTitle(dto.getTitle());
        taskRepository.save(task);  // JPA 的 save 可做 update
        return TaskResponseDTO.fromEntity(task);
    }

    public void deleteTask(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        taskRepository.delete(task);
    }
}
