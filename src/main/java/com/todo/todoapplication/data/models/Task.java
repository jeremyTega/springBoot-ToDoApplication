package com.todo.todoapplication.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private boolean completed = false;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime dueDateTime;
    private LocalDateTime completedAt;

    @DBRef
    private User owner;

}
