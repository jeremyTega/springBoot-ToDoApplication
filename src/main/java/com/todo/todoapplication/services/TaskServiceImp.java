package com.todo.todoapplication.services;

import com.todo.todoapplication.data.models.Task;
import com.todo.todoapplication.data.models.User;
import com.todo.todoapplication.data.repositories.TasksRepo;
import com.todo.todoapplication.dtos.requests.TaskRequest;
import com.todo.todoapplication.dtos.response.TaskResponse;
import com.todo.todoapplication.utils.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService{
//    @Autowired
//    private Task task;

    @Autowired
    private TasksRepo  tasksRepo;

    @Override
    public TaskResponse createTask(TaskRequest dto, User owner){
        Task task = TaskMapper.convertToTask(dto,owner);
        Task savedTask = tasksRepo.save(task);
        return TaskMapper.convertToTaskResponse(savedTask);
    }

    @Override
    public List<TaskResponse> getAllTaskForUser(User user){
        List<Task> tasks = tasksRepo.findByOwner(user);
        return tasks.stream()
                .map(TaskMapper::convertToTaskResponse)
                .toList();
    }

    @Override
    public TaskResponse markTaskAsCompleted(String taskId, User userId) {
        Task task = tasksRepo.findById(taskId)
                        .orElseThrow(()-> new RuntimeException("task not found"));

        if(!task.getOwner().getId().equals(userId)){
            throw new RuntimeException("user not found");
        }
        task.setCompleted(true);
        Task updatedTask = tasksRepo.save(task);
        return TaskMapper.convertToTaskResponse(updatedTask);

    }


}
