package com.todoapp.todoapp.services;

import com.todoapp.todoapp.dto.TaskDTO;
import com.todoapp.todoapp.entitys.Task;
import com.todoapp.todoapp.respositories.TaskRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    public List<TaskDTO> getTasks() {
        List<TaskDTO> tasks = new ArrayList<>();
        
        taskRepository
                .findAllTasksNotCompleted()
                .forEach(t -> {
                    tasks.add(
                            new TaskDTO(
                                    t.getIdTask(),
                                    t.getDescription(),
                                    t.getDateCompleted(),
                                    t.getIsCompleted()
                            )
                    );
                });
        return tasks;
    }
    
    public void createTask(TaskDTO task) {
        Task createTask = new Task();
        createTask.setDescription(task.getDescription());
        createTask.setIsCompleted(false);
        taskRepository.save(createTask);
    }
    
    public boolean deleteTask(Long idTask) {
        boolean exist = taskRepository.existsById(idTask);
        if (!exist) {
            return false;
        }
        taskRepository.deleteById(idTask);
        return true;
    }
    
    public boolean editTask(TaskDTO task) {
        Task updateTask = new Task();
        if (!taskRepository.existsById(task.getId_task())) {
            return false;
        }
        updateTask.setIdTask(task.getId_task());
        updateTask.setDescription(task.getDescription());
        updateTask.setDateCompleted(LocalDate.now());
        updateTask.setIsCompleted(task.getIs_completed());
        taskRepository.save(updateTask);
        return true;
    }

    public List<TaskDTO> getAllTasks() {
              List<TaskDTO> tasks = new ArrayList<>();
        
        taskRepository
                .findAll()
                .forEach(t -> {
                    tasks.add(
                            new TaskDTO(
                                    t.getIdTask(),
                                    t.getDescription(),
                                    t.getDateCompleted(),
                                    t.getIsCompleted()
                            )
                    );
                });
        return tasks;
    }
}
