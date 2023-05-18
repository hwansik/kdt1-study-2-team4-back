package com.example.demo.productTest.form;

import com.example.demo.productTest.entity.JpaProduct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RequestProductForm {

    private String productName;

    private Integer price;

    public JpaProduct toJpaProduct(String productName, Integer price) {
        return new JpaProduct(productName, price);
    }
}
