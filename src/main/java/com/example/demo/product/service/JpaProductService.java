package com.example.demo.product.service;

import com.example.demo.product.entity.JpaProduct;
import com.example.demo.product.foam.ModifyRequestProductForm;

import java.util.List;

public interface JpaProductService {

    List<JpaProduct> find(String categoryId);

    List<JpaProduct> list();
    
    JpaProduct read(Long productId);

    void delete(Long productId);

    JpaProduct modify(Long productId, ModifyRequestProductForm modifyRequestProductForm);
    JpaProduct register(JpaProduct jpaRegisterProduct);
}
