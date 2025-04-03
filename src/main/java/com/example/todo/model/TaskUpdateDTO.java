package com.example.todo.model;

public class TaskUpdateDTO {
    private String title;
    public TaskUpdateDTO() {}

    public TaskUpdateDTO(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
