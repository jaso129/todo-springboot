package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.model.TaskRequestDTO;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public void createTask(TaskRequestDTO task){
        Task newTask = new Task();
        newTask.setTitle(task.getTitle());
        taskRepository.save(newTask);
    }

}
