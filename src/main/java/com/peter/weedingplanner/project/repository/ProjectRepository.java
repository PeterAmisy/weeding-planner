package com.peter.weedingplanner.project.repository;

import com.peter.weedingplanner.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends JpaRepository<Project, Long>, CrudRepository<Project, Long> {

    @Query(
            value = "SELECT * FROM PROJECT c WHERE c.id = ?1",
            nativeQuery = true)
    Project getById(Long customerId);
}
