package com.todo.todoapplication.controllers;

import com.todo.todoapplication.dtos.requests.TaskRequest;
import com.todo.todoapplication.dtos.response.TaskResponse;
import com.todo.todoapplication.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

        @Autowired
        private TaskService taskService;


        @PostMapping("/create")
        public TaskResponse createTask(@RequestBody TaskRequest taskRequest) {
            return taskService.createTask(taskRequest);
        }
}
