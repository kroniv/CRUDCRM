package com.example.CRUDCRM.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Project {

  @Id
  private Long id;

  private String projectName;

  @OneToMany(mappedBy = "project")
  @JsonManagedReference
  private List<SubProject> subProjects;

  @OneToMany(mappedBy = "project")
  @JsonManagedReference
  private List<Task> tasks;

}
