package com.peter.weedingplanner.project.service;

import com.peter.weedingplanner.project.model.Project;
import com.peter.weedingplanner.project.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Project> getAllProject() {
        return (List<Project>) projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public void saveProject(Project project) {
        try {
            projectRepository.save(project);

        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }


    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    public void udpateProject(Long projectId, Project project) {
        boolean existsById = projectRepository.existsById(projectId);
        if (existsById) {
            projectRepository.save(Project.builder()
                    .id(project.getId())
                    .name(project.getName())
                    .startDate(project.getStartDate())
                    .endDate(project.getEndDate())
                    .build());
        } else {
            throw new RuntimeException("Id is not valid, please check your id");
        }
    }
}
