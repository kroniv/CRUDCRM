package com.example.CRUDCRM.controllers;

import com.example.CRUDCRM.dto.SubProjectDTO;
import com.example.CRUDCRM.services.SubProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subproject")
public class SubProjectController {

  @Autowired
  SubProjectService subProjectService;

  @GetMapping("/all")
  public ResponseEntity<List<SubProjectDTO>> getAllProjects() {
    return ResponseEntity.ok(subProjectService.getAllSubProjects());
  }

  @GetMapping("/{id}")
  public ResponseEntity<SubProjectDTO> getProjectId(@PathVariable Long id) {
    if (id == null) {
      return new ResponseEntity<SubProjectDTO>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<SubProjectDTO>(subProjectService.getSubProjectDTOById(id),HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<Void> postProject(@RequestBody SubProjectDTO subProjectDTO) {
    subProjectService.postSubProject(subProjectDTO);
    return ResponseEntity.noContent().build();
  }
}
