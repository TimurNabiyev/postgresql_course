package com.github.timurnabiyev.postgresql_course.models;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDemographics {
    private String customerTypeId;
    private String customerDesc;
}
