package com.example.CRUDCRM.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

  private Long id;

  private String taskName;

  private String taskStatus;

  private Date dateOfCreation;

  private Date dateOfChangedStatus;

  private String desc;

  private Long projectId;

  private Long subProjectId;
}
