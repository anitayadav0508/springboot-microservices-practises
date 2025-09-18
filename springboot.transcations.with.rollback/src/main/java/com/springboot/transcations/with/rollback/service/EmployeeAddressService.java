package com.springboot.transcations.with.rollback.service;


import com.springboot.transcations.with.rollback.entity.Address;
import com.springboot.transcations.with.rollback.repository.EmployeeAddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeAddressService {


    private EmployeeAddressRepository employeeAddressRepository;



    public void saveEmployeeAddressRecord(){
        Address address = new Address();
        address.setCity("Gurugram");
        address.setState("HR");
        address.setCountry("IN");
        address.setEmpId(202);

        employeeAddressRepository.save(address);


    }
}
