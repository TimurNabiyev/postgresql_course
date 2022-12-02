package com.github.timurnabiyev.postgresql_course.models;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCustomerDemo {
    private  Long customerId;
    private Long customerTypeId;
}
