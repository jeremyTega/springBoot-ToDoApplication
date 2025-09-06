package com.todo.todoapplication.utils;

import com.todo.todoapplication.data.models.Task;
import com.todo.todoapplication.dtos.requests.TaskRequest;
import com.todo.todoapplication.dtos.response.TaskResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {
    public static Task convertToTask(TaskRequest tasks) {
        Task task = new Task();
        task.setTitle(tasks.getTitle());
        task.setDescription(tasks.getDescription());
        task.setCompleted(tasks.isCompleted());
        return task;

    }

    public static TaskResponse convertToTaskResponse(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setTitle(task.getTitle());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setCompleted(task.isCompleted());
        taskResponse.setCreatedAt(LocalDateTime.now());
        return taskResponse;
    }
}
