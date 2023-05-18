package com.example.demo.product.repository;

import com.example.demo.product.entity.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProductRepository extends JpaRepository<JpaProduct, Long> {

    List<JpaProduct> findByCategoryIdLike(String categoryId);
}
