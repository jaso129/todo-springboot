package com.example.todo.model;

public class TaskResponseDTO {

    private Long id;
    private String title;
    private boolean completed;

    public TaskResponseDTO() {};

    public TaskResponseDTO(Long id, String title, Boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public boolean isCompleted(){
        return completed;
    }

    public static TaskResponseDTO fromEntity(Task task){
        return new TaskResponseDTO(task.getId(), task.getTitle(), task.getCompleted());
    }

}


