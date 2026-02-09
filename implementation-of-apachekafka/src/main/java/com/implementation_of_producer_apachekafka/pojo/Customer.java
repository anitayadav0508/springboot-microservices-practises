package com.implementation_of_producer_apachekafka.pojo;

import lombok.Data;

@Data
public class Customer {
    private Integer id;
    private String name;
    private String email;
    private String contactNo;
}
