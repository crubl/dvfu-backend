package com.example.demo.service;

import com.example.demo.dto.ProjectResponse;
import com.example.demo.model.Project;
import com.example.demo.model.Task;
import com.example.demo.repository.ProjectRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ProjectResponse> getProjects() {
        List<Project> projects = repository.findAll(Sort.by("id"));
        return toResponses(projects);
    }

    @Transactional(readOnly = true)
    public List<ProjectResponse> getProjectsJoinFetch() {
        List<Project> projects = repository.findAllWithTasks();
        return toResponses(projects);
    }

    public int seed(int projects, int tasksPerProject) {
        return repository.seed(projects, tasksPerProject);
    }

    /**
     * То же самое через обычные циклы:
     * <pre>{@code
     * List<ProjectResponse> result = new ArrayList<>();
     * for (Project project : projects) {
     *     List<String> titles = new ArrayList<>();
     *     for (Task task : project.getTasks()) {
     *         titles.add(task.getTitle());
     *     }
     *     result.add(new ProjectResponse(project.getId(), project.getName(), titles));
     * }
     * return result;
     * }</pre>
     */
    private List<ProjectResponse> toResponses(List<Project> projects) {
        return projects.stream()
                .map(project -> new ProjectResponse(
                        project.getId(),
                        project.getName(),
                        project.getTasks().stream().map(Task::getTitle).toList()
                ))
                .toList();
    }
}
