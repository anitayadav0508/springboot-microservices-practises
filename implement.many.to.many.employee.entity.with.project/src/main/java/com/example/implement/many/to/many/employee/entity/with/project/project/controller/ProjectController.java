package com.example.implement.many.to.many.employee.entity.with.project.project.controller;

import com.example.implement.many.to.many.employee.entity.with.project.project.entity.Project;
import com.example.implement.many.to.many.employee.entity.with.project.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/save")
    public ResponseEntity  createProject(@RequestBody Project project){
        projectService.saveProject(project);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = {"getProjects","/{projectId}"})
    public List<Project> getProjects(@PathVariable(required = false) Long projectId){

        return projectService.getProjects(projectId);
    }


    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity removeProject(@PathVariable(required = false) Long projectId){
        projectService.deleteProject(projectId);

        return new ResponseEntity(HttpStatus.OK);
    }


}
