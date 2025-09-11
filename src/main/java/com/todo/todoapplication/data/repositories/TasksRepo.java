package com.todo.todoapplication.data.repositories;

import com.todo.todoapplication.data.models.Task;
import com.todo.todoapplication.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TasksRepo extends MongoRepository<Task,String> {
    List<Task> findByOwner(User owner);
}
