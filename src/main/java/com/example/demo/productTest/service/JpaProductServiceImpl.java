package com.example.demo.productTest.service;

import com.example.demo.productTest.entity.JpaProduct;
import com.example.demo.productTest.form.RequestProductForm;
import com.example.demo.productTest.repository.JpaProductRepository;

import java.util.List;
import java.util.Optional;

public class JpaProductServiceImpl implements JpaProductService{

    private JpaProductRepository productRepository;
    @Override
    public List<JpaProduct> list() {
        return productRepository.findAll();
    }

    @Override
    public JpaProduct register(RequestProductForm requestProductForm) {
        return productRepository.save(new JpaProduct());
    }

    @Override
    public JpaProduct read(long productId) {
        Optional<JpaProduct> maybeProduct = productRepository.findById(productId);

        if (maybeProduct.isEmpty()) {
            return null;
        }
        // 여기 헷갈림 주의 당연하게 저장된 곳에서 반환할 생각을 하지말고 있다면 반환하는 것이니까
        // maybeProduct를 사용해야함
        return maybeProduct.get();
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public JpaProduct modify(Long productId, RequestProductForm productForm) {
        Optional<JpaProduct> maybeProduct = productRepository.findById(productId);

        if(maybeProduct.isEmpty()) {
            return null;
        }

        JpaProduct jpaProduct = maybeProduct.get();
        jpaProduct.setProductName(productForm.getProductName());
        jpaProduct.setPrice(productForm.getPrice());
        return productRepository.save(jpaProduct);
    }
}
