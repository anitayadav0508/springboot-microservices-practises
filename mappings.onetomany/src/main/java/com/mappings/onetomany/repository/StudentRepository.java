package com.mappings.onetomany.repository;

import com.mappings.onetomany.dto.PurchaseResponse;
import com.mappings.onetomany.entity.Laptop;
import com.mappings.onetomany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query("select new com.mappings.onetomany.dto.PurchaseResponse(s.name,l.lname) from Student s JOIN s.laptops l")
    public List<PurchaseResponse> getWhichStudentGetWhichLaptop();
}



/* { "name":"anita',
     "rollno":123,
     "marks":87,

    laptops:[{
    "id":12,
    "lname":"DELL"
    }]


}*/