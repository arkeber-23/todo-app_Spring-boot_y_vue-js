package com.todoapp.todoapp.controllers;

import com.todoapp.todoapp.dto.TaskDTO;
import com.todoapp.todoapp.services.TaskService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/todo-app")
public class TaskController {

  @Autowired
  private TaskService taskService;

    @GetMapping("/all")
  public List<TaskDTO> getAllTasks() {
    return taskService.getAllTasks();
  }
  
  @GetMapping
  public List<TaskDTO> getTasks() {
    return taskService.getTasks();
  }

  @PostMapping
  public ResponseEntity<Object> createTask(@RequestBody TaskDTO task) {
    HashMap<String, Object> response = new HashMap<>();
    if (task.getDescription().isEmpty()) {
      response.put("status_code", 400);
      response.put("msg", "no se puede procesar la solicitud...");
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    taskService.createTask(task);
    response.put("status_code", 201);
    response.put("msg", "la tarea fue creada correctamente ...");
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Object> editTask(@RequestBody TaskDTO task) {
    HashMap<String, Object> respon = new HashMap<>();
    boolean resp = taskService.editTask(task);
    if (!resp) {
      respon.put("status_code", 400);
      respon.put("msg", "No se puede procesar la solicitud ...");
      return new ResponseEntity<>(respon, HttpStatus.BAD_REQUEST);
    }
    respon.put("status_code", 200);
    respon.put("msg", "Tarea completada correctamente...");
    return new ResponseEntity<>(respon, HttpStatus.OK);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> deleteTask(@PathVariable("id") Long id) {
    HashMap<String, Object> response = new HashMap<>();
    var resp = taskService.deleteTask(id);
    if (!resp) {
      response.put("status_code", 404);
      response.put(
        "msg",
        String.format("la tarea con el id:%d no existe...", id)
      );
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    response.put("status_code", 200);
    response.put(
      "msg",
      String.format("tarea id:%d eliminada correctamente...", id)
    );
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
