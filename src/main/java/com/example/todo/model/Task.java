package com.example.todo.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column
    private boolean completed;

    @Column
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }

    public Task(){}

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Long getId(){
        return id;
    }

    public Boolean getCompleted() {
        return completed;
    }
}
