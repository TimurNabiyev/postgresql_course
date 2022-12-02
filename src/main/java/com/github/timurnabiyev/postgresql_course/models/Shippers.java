package com.github.timurnabiyev.postgresql_course.models;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Shippers {
    private Integer shippersId;
    private String companyName;
    private String phone;

}