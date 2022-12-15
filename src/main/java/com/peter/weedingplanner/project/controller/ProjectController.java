package com.peter.weedingplanner.project.controller;

import com.peter.weedingplanner.project.model.Project;
import com.peter.weedingplanner.project.service.ProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/")
    public List<Project> getAllProject() {
        log.info("start getting projects...");
        List<Project> projectList = projectService.getAllProject();
        return projectList;
    }

    @GetMapping("{projectId}/")
    public Project getProjectById(@PathVariable("projectId") Long id) {
        log.info("getting project by his/her Id");
        return projectService.getProjectById(id);

    }

    @PostMapping("/")
    public void saveCustomer(@RequestBody Project project) {
        projectService.saveProject(project);
    }

    @DeleteMapping("{projectId}/")
    public void deleteCustomer(@PathVariable("projectId") Long projectId) {
        projectService.deleteProject(projectId);
    }

    @PutMapping(path = "{projectId}/")
    public void updateStudent(@PathVariable("projectId") Long projectId,
                              @RequestBody Project project) {
        if (projectId == null || project.getId() == null) {
            throw new IllegalArgumentException("you need to provide an id");
        } else {
            projectService.udpateProject(projectId, project);
        }

    }
}
