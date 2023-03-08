package com.example.CRUDCRM.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Data;

@Entity
@Data
@Table(name = "task")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public class Task {

  @Id
  private Long id;

  private String taskName;

  private String taskStatus;

  private Date dateOfCreation;

  private Date dateOfChangedStatus;

  private String desc;

  @ManyToOne
  @JoinColumn(name = "project_id", referencedColumnName = "id")
  private Project project;

  @ManyToOne
  @JoinColumn(name = "sub_project_id", referencedColumnName = "id")
  private SubProject subProject;
}
