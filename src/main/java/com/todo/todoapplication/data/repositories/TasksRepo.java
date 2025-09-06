package com.todo.todoapplication.data.repositories;

import com.todo.todoapplication.data.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TasksRepo extends MongoRepository<Task,String> {

}
