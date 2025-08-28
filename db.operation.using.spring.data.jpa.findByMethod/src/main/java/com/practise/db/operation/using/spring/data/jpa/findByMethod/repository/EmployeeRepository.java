package com.practise.db.operation.using.spring.data.jpa.findByMethod.repository;

import com.practise.db.operation.using.spring.data.jpa.findByMethod.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Serializable> {

    /*select * from employee_tbl where emp_name = "empName"*/
    public List<Employee>  findByEmpName(String empName);
    /*select * from employee_tbl where emp_sal = "empSalary"*/
    public List<Employee> findByEmpSalary(Double empSalary);
    /*select * from employee_tbl where emp_name = "empName" and emp_sal = "empSalary"*/
    public List<Employee> findByEmpNameAndEmpSalary(String empName,Double empSalary);
    /*select * from employee_tbl where emp_sal > "empSalary"*/
    public List<Employee> findByEmpSalaryGreaterThan(double empSalary);

    /*select * from emp_tbl where emp_name in ('nick','alisha')*/
    public List<Employee> findByEmpNameIn(List<String>names);


    /*this is HQl query instead of native sql query*/
    /*select emp_sal from employee_tbl where emp_name = "name"*/
    @Query("Select empSalary from Employee where empName=:name")
    public Double findEmpSalaryByEmpName(String name);


}
