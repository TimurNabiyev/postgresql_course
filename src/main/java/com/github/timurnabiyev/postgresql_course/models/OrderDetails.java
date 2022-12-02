package com.github.timurnabiyev.postgresql_course.models;

import lombok.*;

import java.math.BigDecimal;
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    private Integer orderId;
    private Integer productId;
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal discount;

}