package com.practise.curd_operation.repository;


import com.practise.curd_operation.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Serializable> {

}
