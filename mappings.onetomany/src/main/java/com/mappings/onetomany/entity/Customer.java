package com.mappings.onetomany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {

   @Id
   @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String gender;
    /*A customer can purchase a list of products*/

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name="cp_fk", referencedColumnName = "id")
    private List<Product> products;

    /* Note: Customer id will act as foreign key in product table */
 }
