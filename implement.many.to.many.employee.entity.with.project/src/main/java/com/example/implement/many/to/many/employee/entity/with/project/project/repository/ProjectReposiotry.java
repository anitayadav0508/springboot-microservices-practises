package com.example.implement.many.to.many.employee.entity.with.project.project.repository;

import com.example.implement.many.to.many.employee.entity.with.project.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectReposiotry extends JpaRepository<Project,Long> {

    List<Project> findAllByProjectId(Long projectId);
}
