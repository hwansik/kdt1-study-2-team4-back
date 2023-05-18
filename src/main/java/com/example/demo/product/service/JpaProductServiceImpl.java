package com.example.demo.product.service;

import com.example.demo.product.entity.JpaProduct;
import com.example.demo.product.foam.ModifyRequestProductForm;
import com.example.demo.product.repository.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JpaProductServiceImpl implements JpaProductService{

    final private JpaProductRepository productRepository;

    @Override
    public List<JpaProduct> list() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }

    @Override
    public JpaProduct read(Long productId) {
        Optional<JpaProduct> maybeJpaProduct = productRepository.findById(productId);

        if (maybeJpaProduct.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }
        return maybeJpaProduct.get();
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }
    
    @Override
    public List<JpaProduct> find(String categoryId){
        if(categoryId.equals("all")){
            return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
        }else{
          return productRepository.findByCategoryIdLike(categoryId);}

    }

    @Override
    public JpaProduct modify(Long productId, ModifyRequestProductForm modifyRequestProductForm) {
        Optional<JpaProduct> maybeJpaProduct = productRepository.findById(productId);

        if (maybeJpaProduct.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        JpaProduct product = maybeJpaProduct.get();
        product.setProductName(modifyRequestProductForm.getProductName());
        product.setProductDetails(modifyRequestProductForm.getProductDetails());

        return productRepository.save(product);
    }

    @Override
    public JpaProduct register(JpaProduct jpaRegisterProduct) {
        return productRepository.save(jpaRegisterProduct);
    }

}
