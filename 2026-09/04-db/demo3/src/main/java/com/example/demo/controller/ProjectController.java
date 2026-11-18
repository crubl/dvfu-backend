package com.example.demo.controller;

import com.example.demo.dto.ProjectResponse;
import com.example.demo.service.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/seed")
    public int seed(@RequestParam(defaultValue = "10") int projects,
                    @RequestParam(defaultValue = "100") int tasksPerProject) {
        return projectService.seed(projects, tasksPerProject);
    }

    @GetMapping
    public List<ProjectResponse> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping("/join-fetch")
    public List<ProjectResponse> getProjectsJoinFetch() {
        return projectService.getProjectsJoinFetch();
    }
}
