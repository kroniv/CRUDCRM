package com.example.CRUDCRM.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "sub_project")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public class SubProject {

  @Id
  private Long id;

  private String subProjectName;

  @ManyToOne(fetch= FetchType.LAZY)
  @JoinColumn(name = "project_id", referencedColumnName = "id")
  private Project project;

  @OneToMany(fetch=FetchType.LAZY, mappedBy = "subProject")
  private List<Task> tasks;
}
