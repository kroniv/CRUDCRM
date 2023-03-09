package com.example.CRUDCRM.controllers;

import com.example.CRUDCRM.dto.TaskDTO;
import com.example.CRUDCRM.services.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
  @Autowired
  TaskService taskService;

  @GetMapping("/all")
  public ResponseEntity<List<TaskDTO>> getAllProjects() {
    return ResponseEntity.ok(taskService.getAllTasks());
  }
  @PostMapping()
  public ResponseEntity<Void> postTask(@RequestBody TaskDTO taskDTO) {
    taskService.postTask(taskDTO);
    return ResponseEntity.noContent().build();
  }
}
