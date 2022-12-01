package com.github.timurnabiyev.postgresql_course.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
public class Shippers {
    private Integer shippersId;
    private String companyName;
    private String phone;

    public Shippers(Integer shippersId, String companyName, String phone) {
        this.shippersId = shippersId;
        this.companyName = companyName;
        this.phone = phone;
    }

}