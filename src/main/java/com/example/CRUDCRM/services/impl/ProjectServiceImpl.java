package com.example.CRUDCRM.services.impl;

import com.example.CRUDCRM.dto.ProjectDTO;
import com.example.CRUDCRM.entities.Project;
import com.example.CRUDCRM.repositories.ProjectRepository;
import com.example.CRUDCRM.services.ProjectService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

  @Autowired
  ProjectRepository projectRepository;

  @Override
  public List<ProjectDTO> getAllProjects() {
    List<Project> allProject = projectRepository.findAll();
    return allProject.stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
  }

  @Override
  public ProjectDTO getProjectDTOById(Long id) {
    Optional<Project> optional = projectRepository.findById(id);
    if (projectRepository.findById(id).isEmpty()) {
      return null;
    } else {
      return toDTO(optional.get());
    }
  }

  @Override
  public void postProject(ProjectDTO projectDTO) {
    Project project = toEntity(projectDTO);
    projectRepository.save(project);
  }

  public Project getProjectById(Long id) {
    if (id == null) {
      return null;
    }
    Optional<Project> optional = projectRepository.findById(id);
    if (projectRepository.findById(id).isEmpty()) {
      return null;
    } else {
      return optional.get();
    }
  }


  private Project toEntity(ProjectDTO projectDTO) {
    return new Project(
        projectDTO.getId(),
        projectDTO.getProjectName(),
        projectDTO.getSubProjects(),
        projectDTO.getTasks()
    );
  }

  private ProjectDTO toDTO(Project project) {
    return new ProjectDTO(
        project.getId(),
        project.getProjectName(),
        project.getSubProjects(),
        project.getTasks()
    );
  }
}
