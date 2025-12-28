package com.mapping.relationship.ManyToMany.repository;

import com.mapping.relationship.ManyToMany.dto.CustomerResponse;
import com.mapping.relationship.ManyToMany.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("SELECT new com.mapping.relationship.ManyToMany.dto.CustomerResponse(c.name, p.productName) FROM Customer c JOIN c.products p")
    public List<CustomerResponse> getAllProductPurchaseByCustomer();
}
