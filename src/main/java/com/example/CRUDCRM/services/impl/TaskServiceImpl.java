package com.example.CRUDCRM.services.impl;

import com.example.CRUDCRM.dto.TaskDTO;
import com.example.CRUDCRM.entities.Task;
import com.example.CRUDCRM.repositories.TaskRepository;
import com.example.CRUDCRM.services.ProjectService;
import com.example.CRUDCRM.services.SubProjectService;
import com.example.CRUDCRM.services.TaskService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

  @Autowired
  TaskRepository taskRepository;
  @Autowired
  SubProjectService subProjectService;
  @Autowired
  ProjectService projectService;

  @Override
  public List<TaskDTO> getAllTasks() {
    List<Task> allTasks = taskRepository.findAll();
    return allTasks.stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
  }

  @Override
  public TaskDTO getTaskByID(Long id) {
    Optional<Task> optional = taskRepository.findById(id);
    if (taskRepository.findById(id).isEmpty()) {
      return null;
    } else {
      return toDTO(optional.get());
    }
  }

  @Override
  public void postTask(TaskDTO taskDTO) {
    Task task = toEntity(taskDTO);
    taskRepository.save(task);
  }


  //Task cannot be null in project.id AND subproject.id (OR possible)
  private Task toEntity(TaskDTO taskDTO) {
    return new Task(
        taskDTO.getId(),
        taskDTO.getTaskName(),
        taskDTO.getTaskStatus(),
        taskDTO.getDateOfCreation(),
        taskDTO.getDateOfChangedStatus(),
        taskDTO.getDesc(),
        projectService.getProjectById(taskDTO.getProjectId()),
        subProjectService.getSubProjecttById(taskDTO.getSubProjectId())
        );
  }

  private TaskDTO toDTO(Task task) {
    return new TaskDTO(
        task.getId(),
        task.getTaskName(),
        task.getTaskStatus(),
        task.getDateOfCreation(),
        task.getDateOfChangedStatus(),
        task.getDesc(),
        projectService.getProjectById(task.getProject().getId()).getId(),
        subProjectService.getSubProjecttById(task.getSubProject().getId()).getId()
    );
  }
}
