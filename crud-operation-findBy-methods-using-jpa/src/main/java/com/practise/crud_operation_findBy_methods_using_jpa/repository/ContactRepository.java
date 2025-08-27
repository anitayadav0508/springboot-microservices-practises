package com.practise.crud_operation_findBy_methods_using_jpa.repository;

import com.practise.crud_operation_findBy_methods_using_jpa.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Serializable> {

    /*Select * from contact where contact_name = "contactName"*/
    Contact findByContactName(String contactName);
    /*Select * from contact where contact_name="contactName" and contact_number = "contactNumber"*/
    Contact findByContactNameAndContactNumber(String contactName,Long contactNumber);
}
