package com.todoapp.todoapp.respositories;

import org.springframework.data.repository.CrudRepository;

import com.todoapp.todoapp.entitys.Task;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends CrudRepository<Task, Long> {

@Query(value = "SELECT t.* FROM tasks t WHERE t.is_completed = false", nativeQuery = true)
Iterable<Task> findAllTasksNotCompleted();
}
