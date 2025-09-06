package com.todo.todoapplication.controllers;

import com.todo.todoapplication.dtos.requests.TaskRequest;
import com.todo.todoapplication.dtos.response.TaskResponse;
import com.todo.todoapplication.services.TaskService;
import com.todo.todoapplication.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

        private TaskService taskService;

        @Autowired
        public void setTaskService(TaskService taskService) {
            this.taskService = taskService;
        }

        @PatchMapping
        public TaskResponse createTask(@RequestBody TaskRequest taskRequest) {
            return taskService.createTask(taskRequest);
        }
}
