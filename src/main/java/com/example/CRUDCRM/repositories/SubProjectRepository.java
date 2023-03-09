package com.example.CRUDCRM.repositories;

import com.example.CRUDCRM.entities.SubProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubProjectRepository extends JpaRepository<SubProject, Long> {

}
