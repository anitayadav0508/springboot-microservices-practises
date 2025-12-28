package com.mapping.relationship.ManyToMany.repository;

import com.mapping.relationship.ManyToMany.entity.Product;
import org.hibernate.boot.jaxb.mapping.spi.JaxbPluralAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
