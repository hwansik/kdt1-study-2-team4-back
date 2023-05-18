package com.example.demo.productTest.service;

import com.example.demo.productTest.entity.JpaProduct;
import com.example.demo.productTest.form.RequestProductForm;

import java.util.List;

public interface JpaProductService  {
    List<JpaProduct> list();

    JpaProduct register(RequestProductForm requestProductForm);

    JpaProduct read(long productId);

    void delete(Long productId);

    JpaProduct modify(Long productId, RequestProductForm productForm);
}
