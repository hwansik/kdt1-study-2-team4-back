package com.example.demo.productTest.repository;

import com.example.demo.productTest.entity.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<JpaProduct, Long> {
}
