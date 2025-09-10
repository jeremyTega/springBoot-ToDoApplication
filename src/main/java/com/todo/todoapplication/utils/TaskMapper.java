package com.todo.todoapplication.utils;

import com.todo.todoapplication.data.models.Task;
import com.todo.todoapplication.dtos.requests.TaskRequest;
import com.todo.todoapplication.dtos.response.TaskResponse;

import java.time.LocalDateTime;

public class TaskMapper {
    public static Task convertToTask(TaskRequest tasks) {
        Task task = new Task();
        task.setTitle(tasks.getTitle());
        task.setDescription(tasks.getDescription());
//        task.setCompleted(tasks.isCompleted());
        return task;

    }

    public static TaskResponse convertToTaskResponse(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setTitle(task.getTitle());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setCompleted(task.isCompleted());
        taskResponse.setCreatedAt(LocalDateTime.now());
        if(task.getOwner() != null){
            taskResponse.setOwner(task.getOwner().getId());
        }
        return taskResponse;
    }
}
