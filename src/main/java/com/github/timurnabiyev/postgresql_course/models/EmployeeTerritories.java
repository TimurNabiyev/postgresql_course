package com.github.timurnabiyev.postgresql_course.models;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeTerritories {
    private Long employeeId;
    private String territoryId;

}