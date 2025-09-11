package com.todo.todoapplication.services;

import com.todo.todoapplication.data.models.User;
import com.todo.todoapplication.dtos.requests.TaskRequest;
import com.todo.todoapplication.dtos.response.TaskResponse;

import java.util.List;

public interface TaskService {
     TaskResponse createTask(TaskRequest taskRequest, User owner);
     List<TaskResponse> getAllTaskForUser  (User user);
     TaskResponse markTaskAsCompleted(String id, String userId);
     TaskResponse updateTask(String taskId, TaskRequest taskRequest, User owner);
     void deleteTask(String id, User owner);


}
