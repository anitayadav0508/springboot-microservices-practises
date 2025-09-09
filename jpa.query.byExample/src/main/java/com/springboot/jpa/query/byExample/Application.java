package com.springboot.jpa.query.byExample;

import com.springboot.jpa.query.byExample.entity.Employee;
import com.springboot.jpa.query.byExample.repository.EmpRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx  =SpringApplication.run(Application.class, args);

        EmpRepository empRepository = ctx.getBean(EmpRepository.class);
        Employee emp = new Employee();
        /*
        *    select
        e1_0.emp_id,
        e1_0.designation,
        e1_0.employee_name,
        e1_0.employee_location,
        e1_0.project_name
    from
        employee e1_0
    where
        e1_0.employee_location=?
        and e1_0.project_name=?  //it will generate dynamic query based on what value we set by setter method
        * if user select projectname is "CTI" from dropdown and employee location is "gurgaon"
        * */
        emp.setProjectName("CTI");
        emp.setEmployeeLoc("gurgaon");
        Example<Employee> employeeExample = Example.of(emp);

      List<Employee> employeeList =   empRepository.findAll(employeeExample);

        System.out.println("++++++++++++++++++++++++++++++++++Display All Records+++++++++++++++++++");
      for(Employee e : employeeList){

          System.out.println(e);
      }


    }

}
