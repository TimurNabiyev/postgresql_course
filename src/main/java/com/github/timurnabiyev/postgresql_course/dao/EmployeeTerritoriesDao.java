package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.EmployeeTerritories;

public interface EmployeeTerritoriesDao {
    public EmployeeTerritories findEmployeeTerritoryByID(Long employeeTerritoryId);
    public long insertEmployeeTerritories(EmployeeTerritories employeeTerritories);
    public int getEmployeeTerritoriesCount();
    public void getEmployeeTerritories();
    public int updateEmployeeTerritories(Long id, EmployeeTerritories employeeTerritory);
    public int deleteEmployeeTerritory(Long id);
}
