package com.example.implement.many.to.many.employee.entity.with.project.project.service;

import com.example.implement.many.to.many.employee.entity.with.project.project.entity.Project;
import com.example.implement.many.to.many.employee.entity.with.project.project.repository.ProjectReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private ProjectReposiotry projectReposiotry;

    @Autowired
    ProjectService(ProjectReposiotry projectReposiotry){

        this.projectReposiotry =  projectReposiotry;
    }

    public void saveProject(Project project){

        this.projectReposiotry.save(project);
    }

    public List<Project> getProjects(Long projectId){
        if(projectId!=null){
            return this.projectReposiotry.findAllByProjectId(projectId);
        }else{
            return this.projectReposiotry.findAll();
        }
    }


    public void deleteProject(Long projectId){
        projectReposiotry.deleteById(projectId);
    }

}
