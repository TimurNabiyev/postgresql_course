package com.github.timurnabiyev.postgresql_course.models;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private Integer orderId;
    private String customerId;
    private Integer employeeId;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private Integer shipVia;
    private BigDecimal freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;

}