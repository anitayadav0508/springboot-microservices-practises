package com.springboot.transcations.with.rollback.repository;

import com.springboot.transcations.with.rollback.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface EmployeeAddressRepository extends
        JpaRepository<Address, Serializable> {
}
