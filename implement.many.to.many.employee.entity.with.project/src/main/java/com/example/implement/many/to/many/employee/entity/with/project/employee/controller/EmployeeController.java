package com.example.implement.many.to.many.employee.entity.with.project.employee.controller;

import com.example.implement.many.to.many.employee.entity.with.project.employee.entity.Employee;
import com.example.implement.many.to.many.employee.entity.with.project.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping(value = {"getEmployees","/{empId}"})
    public List<Employee> getEmployee(@PathVariable(required = false) Long empId){
        return employeeService.getEmployedDetails(empId);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity removeEmployee(@PathVariable Long empId){
         employeeService.DeleteEmployee(empId);

         return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{empId}/project/{projectId}")
    public Employee assignedProjectsToEmployees(@PathVariable Long empId,@PathVariable Long projectId){
        return employeeService.assignedProjectsToEmployees(empId,projectId);
    }

    /*Assign multiple projects to an employee at once*/
    @PutMapping("{empId}/projects")
    public Employee assignMultipleProjectsToEmployee(@PathVariable Long empId, @RequestBody List<Long> projectIds){
        return employeeService.assignMultipleProjectsToEmployee(empId, projectIds);
    }

}
