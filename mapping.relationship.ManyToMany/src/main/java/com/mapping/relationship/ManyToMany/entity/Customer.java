package com.mapping.relationship.ManyToMany.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "CUSTOMER_TBL")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "CUSTOMER_PRODUCT_TBL",
            joinColumns = {
            @JoinColumn(name = "customer_id",referencedColumnName = "id"),

            },
            inverseJoinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "id")
            }
    )

    Set<Product> products;

}
