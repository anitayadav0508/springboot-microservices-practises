package com.springboot.webmvc.passing.data.by.differentway.from.UI.to.Server.Respository;

import com.springboot.webmvc.passing.data.by.differentway.from.UI.to.Server.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRespository extends JpaRepository<Product,Long> {
}
