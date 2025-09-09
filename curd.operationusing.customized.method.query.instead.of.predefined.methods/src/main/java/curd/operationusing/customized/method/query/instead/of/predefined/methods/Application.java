package curd.operationusing.customized.method.query.instead.of.predefined.methods;

import curd.operationusing.customized.method.query.instead.of.predefined.methods.dto.ProductView;
import curd.operationusing.customized.method.query.instead.of.predefined.methods.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

      ConfigurableApplicationContext ctx =SpringApplication.run(Application.class, args);
      ProductRepository bean =ctx.getBean(ProductRepository.class);
     List<ProductView> productList = bean.findProductNameAndPriceByProductId(101l);

     productList.forEach(product ->{
         System.out.println("ProductName " + product.getProductName() + "ProductPrice " + product.getPrice());
     });

	}

}
