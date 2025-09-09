package com.practise.db.operation.using.spring.data.jpa.findByMethod;

import com.practise.db.operation.using.spring.data.jpa.findByMethod.entity.Employee;
import com.practise.db.operation.using.spring.data.jpa.findByMethod.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

      ConfigurableApplicationContext ctx =  SpringApplication.run(Application.class, args);
       EmployeeRepository bean = ctx.getBean(EmployeeRepository.class);
        List<Employee> employeeList = bean.findByEmpName("nick");
        System.out.println( "+++++++++++++Find Employee by name++++++++++++"+ employeeList);
       List<Employee> employees =  bean.findByEmpSalary(20000.0);
        System.out.println("+++++++++++Find employee by salary+++++++++++++"+ employees);

       List<Employee> employeeBasedOnNameAndSal =
               bean.findByEmpNameAndEmpSalary("nick", 20000.0);
        System.out.println("++++++++++Find employee based on name & salary++++++++++++" +  employeeBasedOnNameAndSal);

        List<Employee> employeesSalaryGreaterThan =  bean.findByEmpSalaryGreaterThan(20000.0);
        System.out.println("++++++++++++Find employees whose salary greater than+++++++++" + employeesSalaryGreaterThan);

        List<Employee> byEmpNameIn = bean.findByEmpNameIn(Arrays.asList("nick", "alisha"));
        System.out.println("+++++++++++++ find employee record whose names in the given" +  byEmpNameIn);




        Double salary = bean.findEmpSalaryByEmpName("nick");
        System.out.println("++++++++++salary of employee nick is " + salary);


    }

}
