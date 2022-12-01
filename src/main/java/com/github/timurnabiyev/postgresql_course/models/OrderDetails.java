package com.github.timurnabiyev.postgresql_course.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
@Data
@Builder
@ToString
@NoArgsConstructor
public class OrderDetails {
    private Integer orderId;
    private Integer productId;
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal discount;

    public OrderDetails(Integer orderId, Integer productId, BigDecimal unitPrice, Integer quantity, BigDecimal discount) {
        this.orderId = orderId;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.discount = discount;
    }

}