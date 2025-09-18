package com.springboot.transcations.with.rollback;

import com.springboot.transcations.with.rollback.entity.Address;
import com.springboot.transcations.with.rollback.entity.Employee;
import com.springboot.transcations.with.rollback.repository.EmployeeAddressRepository;
import com.springboot.transcations.with.rollback.repository.EmployeeRepository;
import com.springboot.transcations.with.rollback.service.EmployeeAddressService;
import com.springboot.transcations.with.rollback.service.EmployeeManageService;
import com.springboot.transcations.with.rollback.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {


        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        EmployeeService employeeService = ctx.getBean(EmployeeService.class);
        EmployeeAddressService employeeAddressServiceBean = ctx.getBean(EmployeeAddressService.class);

        /*leads to autoCommit()(by default transaction behaviour is autocommit)  transaction by default i.e employee record save and commit to
         * database and after this we get exception so Address entity(employee_address data into ) data into
         * employee address table is not save or persist which is not correct because
         * if employee_address data  is not save/persist to database so empolyee data will not
         * persist into database so we have to set autoComiit() transaction by default false */



        /* if i use @Transactional(rollbackFor = Exception.class) on employee Service class method on
        saveEmployeeRecord() method and same annotaton on employeeAddress Service class method on
        saveEmployeeAddressRecord() in that case i call both method from main() method of main class
        and exception statement also here like below snippet code it's won't work as expected reason below
            employeeService.saveEmployeeRecord();
             int c = 10/0;
             employeeAddressServiceBean.saveEmployeeAddressRecord();


        You want transaction rollback across Employee and Address save operations. But right now:

            employeeService.saveEmployeeRecord() runs in its own transaction (commits when it finishes).

            Then int c = 10/0; throws an exception in your main method outside of any transaction.

                  So Employee record is already committed.

                   Rollback can only happen within the same transaction context(so exception and transactional annotation  must
                   be in same transaction context .*/

        EmployeeManageService employeeManageService = ctx.getBean(EmployeeManageService.class);
        employeeManageService.saveEmployeeRecords();


    }

}
