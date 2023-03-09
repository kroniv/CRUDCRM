package com.example.CRUDCRM.services;

import com.example.CRUDCRM.dto.ProjectDTO;
import com.example.CRUDCRM.entities.Project;
import java.util.List;


public interface ProjectService {

  public List<ProjectDTO> getAllProjects();
  public ProjectDTO getProjectDTOById(Long id);
  public Project getProjectById(Long id);
  public void postProject(ProjectDTO projectDTO);

}
