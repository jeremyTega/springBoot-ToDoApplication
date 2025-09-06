package com.todo.todoapplication.services;

import com.todo.todoapplication.dtos.requests.TaskRequest;
import com.todo.todoapplication.dtos.response.TaskResponse;

import java.util.List;

public interface TaskService {
     TaskResponse createTask(TaskRequest taskRequest);
//     TaskResponse updateTask(TaskRequest taskRequest);
//     void deleteTask(String id);
//     List<TaskResponse> getAllTasks();
//     TaskResponse getTaskById(String id);
}
