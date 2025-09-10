package com.todo.todoapplication.services;

import com.todo.todoapplication.data.models.Task;
import com.todo.todoapplication.data.repositories.TasksRepo;
import com.todo.todoapplication.dtos.requests.TaskRequest;
import com.todo.todoapplication.dtos.response.TaskResponse;
import com.todo.todoapplication.utils.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImp implements TaskService{
//    @Autowired
//    private Task task;

    @Autowired
    private TasksRepo  tasksRepo;

    @Override
    public TaskResponse createTask(TaskRequest dto){
        Task task = TaskMapper.convertToTask(dto);
        Task savedTask = tasksRepo.save(task);
        return TaskMapper.convertToTaskResponse(savedTask);
    }


}
