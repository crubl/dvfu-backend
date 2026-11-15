package com.example.demo.repository;

import com.example.demo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("select p from Project p left join fetch p.tasks order by p.id")
    List<Project> findAllWithTasks();

    @Transactional
    @Modifying
    @Query(value = """
            with new_projects as (
                insert into projects (name)
                select 'Project ' || g from generate_series(1, :projects) g
                returning id, name
            )
            insert into tasks (title, done, project_id)
            select p.name || ' / Task ' || g, random() < 0.5, p.id
            from new_projects p
            cross join generate_series(1, :tasksPerProject) g
            """, nativeQuery = true)
    int seed(@Param("projects") int projects, @Param("tasksPerProject") int tasksPerProject);
}
