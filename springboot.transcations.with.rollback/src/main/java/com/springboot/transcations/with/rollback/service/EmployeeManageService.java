package com.springboot.transcations.with.rollback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeManageService {


    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private  EmployeeAddressService employeeAddressService;

    public EmployeeManageService(EmployeeService employeeService,EmployeeAddressService employeeAddressService){
        this.employeeService = employeeService;
        this.employeeAddressService = employeeAddressService;

    }

@Transactional(rollbackFor = Exception.class)
    public void saveEmployeeRecords(){
        employeeService.saveEmployeeRecord();
       int c = 10/0; /* after commented or without commented */
        employeeAddressService.saveEmployeeAddressRecord();
    }
}
