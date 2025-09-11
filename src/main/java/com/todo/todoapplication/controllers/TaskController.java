package com.todo.todoapplication.controllers;

import com.todo.todoapplication.data.models.User;
import com.todo.todoapplication.dtos.requests.DeleteTaskRequest;
import com.todo.todoapplication.dtos.requests.GetTaskId;
import com.todo.todoapplication.dtos.requests.TaskRequest;
import com.todo.todoapplication.dtos.response.TaskResponse;
import com.todo.todoapplication.services.JwtService;
import com.todo.todoapplication.services.TaskService;
import com.todo.todoapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;


    @PostMapping("/create")
    public TaskResponse createTask(@RequestBody TaskRequest taskRequest, @RequestHeader(value = "Authorization", required = false) String authHeader) {
        String userId = jwtService.AuthToken(authHeader);
        User user = userService.findExistingUserById(userId);
        return taskService.createTask(taskRequest, user);
    }

    @GetMapping("getTask")
    public List<TaskResponse> getTasks(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        String userId = jwtService.AuthToken(authHeader);
        User user = userService.findExistingUserById(userId);
        return taskService.getAllTaskForUser(user);
    }

    @PatchMapping("/complete")
    public TaskResponse markAsComplete(@RequestBody GetTaskId request, @RequestHeader("Authorization") String authHeader) {
        String userId = jwtService.AuthToken(authHeader);
        //        String userId = userService.findExistingUserById(userId);
        return taskService.markTaskAsCompleted(request.getTaskId(), userId);
    }

    @PutMapping("/task/")
    public TaskResponse updateTask(
            @RequestBody String taskId,
            @RequestBody TaskRequest taskRequest,
            @RequestHeader(value = "Authorization") String authHeader) {
        String userId = jwtService.AuthToken(authHeader);
        User user = userService.findExistingUserById(userId);
        return taskService.updateTask(taskId, taskRequest, user);
    }

    @DeleteMapping("/task")
    public void deleteTask(@RequestBody DeleteTaskRequest request, @RequestHeader("Authorization") String authHeader) {
        String userId = jwtService.AuthToken(authHeader);
        User user = userService.findExistingUserById(userId);
        taskService.deleteTask(request.getTaskId(),  user);
    }

}