package com.example.CRUDCRM.services;

import com.example.CRUDCRM.dto.TaskDTO;
import java.util.List;

public interface TaskService {

  public List<TaskDTO> getAllTasks();
  public TaskDTO getTaskByID(Long id);
  public void postTask(TaskDTO taskDTO);
}
