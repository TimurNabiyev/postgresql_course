package com.github.timurnabiyev.postgresql_course.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
public class CustomerDemographics {
    private String customerTypeId;
    private String customerDesc;

    public CustomerDemographics(String customerTypeId, String customerDesc) {
        this.customerTypeId = customerTypeId;
        this.customerDesc = customerDesc;
    }

}
