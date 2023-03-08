package com.example.CRUDCRM.dto;

import com.example.CRUDCRM.entities.SubProject;
import com.example.CRUDCRM.entities.Task;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

  private Long id;

  private String projectName;


  private List<SubProject> subProjects;


  private List<Task> tasks;
}
