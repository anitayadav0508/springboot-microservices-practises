package com.mappings.onetomany.controller;

import com.mappings.onetomany.dto.PurchaseRequest;
import com.mappings.onetomany.dto.PurchaseResponse;
import com.mappings.onetomany.entity.Student;
import com.mappings.onetomany.repository.LaptopRepository;
import com.mappings.onetomany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LaptopRepository laptopRepository;


    @PostMapping("/purchase")
    public Student purchaseLaptop(@RequestBody PurchaseRequest purchaseRequest){

        return studentRepository.save(purchaseRequest.getStudent());

    }

    @GetMapping("/getInfoLaptopAssignToWhichStudent")
    public List<PurchaseResponse> getInformationOfStudentWhichLaptopPurchase(){
        return studentRepository.getWhichStudentGetWhichLaptop();

    }
}
