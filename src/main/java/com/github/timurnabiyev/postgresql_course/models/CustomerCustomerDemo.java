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
    private  Long customerId;
    private Long customerTypeId;


    public CustomerCustomerDemo(Long customerId, Long customerTypeId) {
        this.customerId = customerId;
        this.customerTypeId = customerTypeId;
    }

}
