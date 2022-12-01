package com.github.timurnabiyev.postgresql_course.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
public class EmployeeTerritories {
    private Integer employee;
    private String territoryId;

    public EmployeeTerritories(Integer employee, String territoryId) {
        this.employee = employee;
        this.territoryId = territoryId;
    }

}