package com.practise.crud_operation_findBy_methods_using_jpa;

import com.practise.crud_operation_findBy_methods_using_jpa.entity.Contact;
import com.practise.crud_operation_findBy_methods_using_jpa.repository.ContactRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CrudOperationFindByMethodsUsingJpaApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx =  SpringApplication.run(CrudOperationFindByMethodsUsingJpaApplication.class, args);
        ContactRepository bean = ctx.getBean(ContactRepository.class);


        /* ------ Start to Save 3 records into contact table by saveAll() method*/
        Contact contact1 = new Contact();
        contact1.setContactId(101);
        contact1.setContactName("Nick");
        contact1.setContactNumber(9779749012l);
        Contact contact2 = new Contact();
        contact2.setContactId(102);
        contact2.setContactName("Apurva");
        contact2.setContactNumber(9582118489l);
        Contact contact3 = new Contact();
        contact3.setContactId(103);
        contact3.setContactName("Vijay");
        contact3.setContactNumber(9811669636l);
        List<Contact> contactList = new ArrayList<>();
        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);

        Iterable<Contact> contacts = bean.saveAll(contactList);

        contacts.forEach(contact ->{
            System.out.println("++++++++++++++saved contact++++++++++" + contact);
        });

        /* End ----- Save 3 records into contact table by saveAll() method -- */

        Contact contact = bean.findByContactName("Nick");
        System.out.println("+++++++find record based on contactName+++++++++++" + contact);

        Contact contactbasedOnMulitpleCondition =  bean.findByContactNameAndContactNumber("Apurva",9582118489l);
        System.out.println("+++++++find record based on contactName And Number +++++++++++" + contactbasedOnMulitpleCondition);



    }

}
