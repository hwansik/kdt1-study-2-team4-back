package com.example.demo.productTest;

import com.example.demo.productTest.entity.JpaProduct;
import com.example.demo.productTest.form.RequestProductForm;
import com.example.demo.productTest.service.JpaProductService;
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
    public List<JpaProduct> jpaProductList() {
        List<JpaProduct> returnedJpaProductList = productService.list();
        return returnedJpaProductList;
    }

    @GetMapping("/register")
    public JpaProduct registerProduct (@RequestBody RequestProductForm requestProductForm) {
        return productService.register(requestProductForm);
    }

    @PostMapping("/{productId}")
    public JpaProduct readProduct (@PathVariable Long productId) {
        return productService.read(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct (@PathVariable Long productId) {
        productService.delete(productId);
    }

    @PutMapping("/{productId}")
    public JpaProduct modifyProduct (@PathVariable Long productId,
                                     @RequestBody RequestProductForm productForm) {
        return productService.modify(productId, productForm);
    }

}
