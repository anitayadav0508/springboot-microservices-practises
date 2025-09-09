package curd.operationusing.customized.method.query.instead.of.predefined.methods.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductView {
    public String productName;
    public Double price;
}
