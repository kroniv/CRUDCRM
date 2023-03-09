package com.example.CRUDCRM.services;


import com.example.CRUDCRM.dto.SubProjectDTO;
import com.example.CRUDCRM.entities.SubProject;
import java.util.List;

public interface SubProjectService {

  public List<SubProjectDTO> getAllSubProjects();
  public SubProjectDTO getSubProjectDTOById(Long id);
  public SubProject getSubProjecttById(Long id);
  public void postSubProject(SubProjectDTO subProjectDTO);


}
