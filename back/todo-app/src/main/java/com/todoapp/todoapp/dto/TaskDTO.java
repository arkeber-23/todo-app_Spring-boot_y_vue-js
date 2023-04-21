package com.todoapp.todoapp.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO implements Serializable {

  private Long id_task;
  private String description;
  private LocalDate date_completed;
  private Boolean is_completed;

}
