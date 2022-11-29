package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.EmployeeTerritories;

public interface EmployeeTerritoriesDao {
    public EmployeeTerritories find(Long employeeTerritoryId);
    public EmployeeTerritories save(EmployeeTerritories employeeTerritories);
}
