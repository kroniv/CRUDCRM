package com.example.CRUDCRM.controllers;

import com.example.CRUDCRM.dto.ProjectDTO;
import com.example.CRUDCRM.entities.Project;
import com.example.CRUDCRM.services.ProjectService;
import java.util.List;
import javax.print.attribute.standard.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

  @Autowired
  ProjectService projectService;

  @GetMapping("/all")
  public ResponseEntity<List<ProjectDTO>> getAllProjects() {
    return ResponseEntity.ok(projectService.getAllProjects());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProjectDTO> getProjectId(@PathVariable Long id) {
    if (id == null) {
      return new ResponseEntity<ProjectDTO>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<ProjectDTO>(projectService.getProjectById(id),HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<Void> postProject(@RequestBody ProjectDTO projectDTO) {
    projectService.postProject(projectDTO);
    return ResponseEntity.noContent().build();
  }
}
