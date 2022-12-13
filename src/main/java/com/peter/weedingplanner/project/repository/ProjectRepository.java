package com.peter.weedingplanner.project.repository;

import com.peter.weedingplanner.project.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
