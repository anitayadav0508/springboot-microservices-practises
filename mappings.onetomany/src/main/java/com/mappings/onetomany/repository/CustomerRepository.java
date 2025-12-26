package com.mappings.onetomany.repository;

import com.mappings.onetomany.dto.OrderResponse;
import com.mappings.onetomany.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("SELECT new com.mappings.onetomany.dto.OrderResponse(c.name, p.productName) FROM Customer c JOIN c.products p")
    List<OrderResponse> getJoinInformation();


}
