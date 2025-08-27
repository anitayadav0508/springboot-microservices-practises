package com.practise.crud_operation_findBy_methods_using_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="contact")

public class Contact {


    @Column(name="contact_id")
    @Id
    private Integer contactId;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "contact_number")
    private Long contactNumber;

}
