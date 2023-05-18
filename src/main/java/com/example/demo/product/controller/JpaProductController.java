package com.example.demo.product.controller;

import com.example.demo.product.entity.JpaProduct;
import com.example.demo.product.foam.ModifyRequestProductForm;
import com.example.demo.product.foam.RegisterRequestProductForm;
import com.example.demo.product.service.JpaProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-product")
public class JpaProductController {

    final private JpaProductService productService;

    @GetMapping("/list")
    public List<JpaProduct> productList(){
        log.info("productList()");
        List<JpaProduct> returnedProductList = productService.list();
        log.info("returnedProductList: " + returnedProductList);
        return returnedProductList;
    }

    @GetMapping("/{productId}")
    public JpaProduct readProduct (@PathVariable("productId") Long productId) {
        log.info("readProduct()");

        return productService.read(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct (@PathVariable("productId") Long productId) {
        log.info("deleteProduct()");

        productService.delete(productId);
    }

    @GetMapping("/category/{categoryId}")
    public List<JpaProduct> productCategoryList(@PathVariable("categoryId") String categoryId){
        List<JpaProduct> returFinedProductList= productService.find(categoryId);
        log.info("categoryId: " + categoryId);
        return returFinedProductList;
    }
    @PutMapping("/{productId}")
    public JpaProduct modifyProduct (@PathVariable("productId") Long productId,
                                 @RequestBody ModifyRequestProductForm modifyRequestProductForm) {
        log.info("modifyBoard(): " + modifyRequestProductForm + ", id: " + productId);

        return productService.modify(productId, modifyRequestProductForm);
    }

    @PostMapping("/register")
    public JpaProduct registerProduct (@RequestBody RegisterRequestProductForm registerRequestProductForm) {
        log.info("registerProduct()");

        return productService.register(registerRequestProductForm.toJPaProduct());
    }

}