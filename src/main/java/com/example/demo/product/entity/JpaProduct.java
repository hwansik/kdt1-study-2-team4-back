package com.example.demo.product.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class JpaProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Setter
    private String productName;

    @Setter
    private Integer productPrice;

    private String manufacturer;

    @Setter
    private String mfgDate;

    @Setter
    private String expDate;
    private String categoryId;

    @Setter
    private String productDetails;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private LocalDateTime createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @UpdateTimestamp
    private LocalDateTime  updateDate;

    public JpaProduct(
            String productName,
            Integer productPrice,
            String mfgDate,
            String expDate,
            String productDetails) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.mfgDate = mfgDate;
        this.expDate = expDate;
        this.productDetails = productDetails;
    }

    public JpaProduct(String productName,
                      Integer productPrice,
                      String manufacturer,
                      String mfgDate,
                      String expDate,
                      String categoryId,
                      String productDetails) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.manufacturer = manufacturer;
        this.mfgDate = mfgDate;
        this.expDate = expDate;
        this.categoryId = categoryId;
        this.productDetails = productDetails;
    }
}
