package com.example.CRUDCRM.services;

import com.example.CRUDCRM.dto.ProjectDTO;
import com.example.CRUDCRM.entities.Project;
import java.util.List;
import org.springframework.stereotype.Service;


public interface ProjectService {

  public List<ProjectDTO> getAllProjects();
  public ProjectDTO getProjectById(Long id);
  public void postProject(Project project);
}
