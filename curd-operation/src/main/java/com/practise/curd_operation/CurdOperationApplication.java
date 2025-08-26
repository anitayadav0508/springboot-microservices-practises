package com.practise.curd_operation;

import com.practise.curd_operation.entity.Employee;
import com.practise.curd_operation.repository.EmployeeRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CurdOperationApplication {

	public static void main(String[] args) {

    ConfigurableApplicationContext ctx =  SpringApplication.run(CurdOperationApplication.class, args);
    EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("++++++++++++ Proxy class whose implement crudRepository interface" + employeeRepository.getClass().getName());

        Employee emp1 = new Employee();
       emp1.setEmpId(3);
        emp1.setEmpName("EMP" + "test123");
        emp1.setEmpSalary(20000l);
//        employeeRepository.save(emp1); to save on record

        Employee emp2 = new Employee();
        emp2.setEmpId(4);
        emp2.setEmpName("EMP" + "new12");
        emp2.setEmpSalary(20000l);
//        employeeRepository.save(emp2);

        List<Employee> emplist = new ArrayList<Employee>();
        emplist.add(emp1);
        emplist.add(emp2);
        employeeRepository.saveAll(emplist); //to save muliple records

        Optional<Employee> employee = employeeRepository.findById(3);


        if(employee.isPresent()){
            System.out.println("+++++++++Record+++++++++++" + employee.get());
        }else{
            System.out.println("++++++++++++No Record Found++++++++++++");
        }
        
        
        List<Serializable> empIds =  new ArrayList<>();
        empIds.add(3);
        empIds.add(4);
        empIds.add(5);

        Iterable<Employee> employeeIterable = employeeRepository.findAllById(empIds);

        employeeIterable.forEach( emp-> {
                    System.out.println(emp);
        }
        );


        Iterable<Employee> all = employeeRepository.findAll();
        all.forEach(emp -> System.out.println(emp));

        long count = employeeRepository.count();

        /*Which table record will count , employeeRepository is bind out Employee entity and employee entity bind to
        * emp_table so only employee table record will count, employee entity is mediator b/w employee repository and employee entity*/
        System.out.println("Total Records  in employeeRepository++++++++++++++" + count);

    }

}
