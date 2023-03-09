package com.example.CRUDCRM.services.impl;

import com.example.CRUDCRM.dto.SubProjectDTO;
import com.example.CRUDCRM.entities.SubProject;
import com.example.CRUDCRM.repositories.SubProjectRepository;
import com.example.CRUDCRM.services.ProjectService;
import com.example.CRUDCRM.services.SubProjectService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubProjectImpl implements SubProjectService {

  @Autowired
  SubProjectRepository subProjectRepository;

  @Autowired
  ProjectService projectService;

  @Override
  public List<SubProjectDTO> getAllSubProjects() {
    List<SubProject> allSubProjects = subProjectRepository.findAll();
    return allSubProjects.stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
  }

  @Override
  public SubProjectDTO getSubProjectDTOById(Long id) {
    Optional<SubProject> optional = subProjectRepository.findById(id);
    if (subProjectRepository.findById(id).isEmpty()) {
      return null;
    } else {
      return toDTO(optional.get());
    }
  }

  @Override
  public SubProject getSubProjecttById(Long id) {
    if (id == null) {
      return null;
    }
    Optional<SubProject> optional = subProjectRepository.findById(id);
    if (subProjectRepository.findById(id).isEmpty()) {
      return null;
    } else {
      return optional.get();
    }
  }

  @Override
  public void postSubProject(SubProjectDTO subProjectDTO) {
    SubProject subProject = toEntity(subProjectDTO);
    subProjectRepository.save(subProject);
  }

  //Subproject cannot be null in project.id

  private SubProjectDTO toDTO(SubProject subProject) {
    return new SubProjectDTO(
        subProject.getId(),
        subProject.getSubProjectName(),
        projectService.getProjectById(subProject.getId()).getId(),
        subProject.getTasks()
    );
  }

  private SubProject toEntity(SubProjectDTO subProjectDTO) {
    return new SubProject(
        subProjectDTO.getId(),
        subProjectDTO.getSubProjectName(),
        projectService.getProjectById(subProjectDTO.getProjectId()),
        subProjectDTO.getTasks()
    );
  }
}
