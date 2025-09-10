package com.todo.todoapplication.dtos.requests;

import lombok.Data;

@Data
public class TaskRequest {
    private String title;
    private String description;
   }
