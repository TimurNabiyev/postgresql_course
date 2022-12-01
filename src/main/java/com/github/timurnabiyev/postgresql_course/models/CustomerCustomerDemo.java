package com.github.timurnabiyev.postgresql_course.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
public class CustomerCustomerDemo {
    private String customerId;
    private String customerTypeId;


    public CustomerCustomerDemo(String customerId, String customerTypeId) {
        this.customerId = customerId;
        this.customerTypeId = customerTypeId;
    }

}
