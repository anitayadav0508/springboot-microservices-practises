package com.example.implement.many.to.many.employee.entity.with.project.employee.service;

import com.example.implement.many.to.many.employee.entity.with.project.employee.entity.Employee;
import com.example.implement.many.to.many.employee.entity.with.project.employee.repository.EmployeeRepository;
import com.example.implement.many.to.many.employee.entity.with.project.project.entity.Project;
import com.example.implement.many.to.many.employee.entity.with.project.project.repository.ProjectReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectReposiotry projectReposiotry;

    public void saveEmployee(Employee emp){

         employeeRepository.save(emp);

    }

    public List<Employee> getEmployedDetails(Long empId){
       if(empId!= null){
           return employeeRepository.findAllByEmpId(empId);
       }else{
           return employeeRepository.findAll();
       }
    }


    public void DeleteEmployee(Long empId){
         employeeRepository.deleteById(empId);
    }

    public Employee assignedProjectsToEmployees(Long empId, Long projectId) {

        /*In order to assign project to my employee first i need to fetch employee object from db*/

       Employee  employee =  employeeRepository.findById(empId).get();

        Project project = projectReposiotry.findById(projectId).get();

        Set<Project> projectSet = employee.getAssignedProjects();
        /*First we need to fetch all assigned project only then we have to append/assign new project to employee*/
        projectSet.add(project);

        employee.setAssignedProjects(projectSet);
        return employeeRepository.save(employee);
    }

    /*Assign multiple projects to an employee at once*/
    public Employee assignMultipleProjectsToEmployee(Long empId, List<Long> projectIds) {

        Employee employee = employeeRepository.findById(empId).get();

        /*Fetch all projects by their IDs*/
        List<Project> projects = projectReposiotry.findAllById(projectIds);

        /*Add all projects to employee's existing assigned projects*/
        Set<Project> projectSet = employee.getAssignedProjects();
        projectSet.addAll(projects);

        employee.setAssignedProjects(projectSet);
        return employeeRepository.save(employee);
    }
}
