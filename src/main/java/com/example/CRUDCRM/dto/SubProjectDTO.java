package com.example.CRUDCRM.dto;

import com.example.CRUDCRM.entities.Task;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubProjectDTO {

  private Long id;

  private String subProjectName;

  private Long projectId;

  private List<Task> tasks;
}
