package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(String title) {
        return repository.save(new Task(title));
    }

    public Page<Task> getTasks(Boolean done, Pageable pageable) {
        if (done == null) {
            return repository.findAll(pageable);
        }
        return repository.findByDone(done, pageable);
    }

    public Task getTask(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Transactional
    public Task update(Long id, String title, boolean done) {
        Task task = getTask(id);
        task.setTitle(title);
        task.setDone(done);
        return task;
    }

    public void markDone(Long id) {
        int updated = repository.markDone(id);
        if (updated == 0) {
            throw new TaskNotFoundException(id);
        }
    }

    @Transactional
    public void delete(Long id) {
        Task task = getTask(id);
        repository.delete(task);
    }
}
