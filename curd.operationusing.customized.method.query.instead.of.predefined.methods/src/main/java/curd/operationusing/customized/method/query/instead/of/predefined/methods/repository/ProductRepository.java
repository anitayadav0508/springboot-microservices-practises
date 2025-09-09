package curd.operationusing.customized.method.query.instead.of.predefined.methods.repository;

import curd.operationusing.customized.method.query.instead.of.predefined.methods.dto.ProductView;
import curd.operationusing.customized.method.query.instead.of.predefined.methods.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Serializable> {


    @Query("select new curd.operationusing.customized.method.query.instead.of.predefined.methods.dto.ProductView(p.productName, p.price) " +
            "from Product p where p.productId = :productId")
    List<ProductView> findProductNameAndPriceByProductId(Long productId);
}
