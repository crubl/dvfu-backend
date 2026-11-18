package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByDone(boolean done);

    Page<Task> findByDone(boolean done, Pageable pageable);

    List<Task> findByTitleContainingIgnoreCase(String part);

    List<Task> findByTitle(String title);

    long countByDone(boolean done);

    @Query("select t from Task t where t.done = false order by t.id")
    List<Task> findOpenTasks();

    @Transactional
    @Modifying
    @Query("update Task t set t.done = true where t.id = :id")
    int markDone(@Param("id") Long id);
}
