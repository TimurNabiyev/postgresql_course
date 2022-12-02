package com.github.timurnabiyev.postgresql_course.models;

import lombok.*;

import java.math.BigDecimal;
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    private Integer productId;
    private String productName;
    private Integer supplierId;
    private Integer categoryId;
    private String quantityPerUnit;
    private BigDecimal unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Integer discontinued;

}