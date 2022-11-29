package com.github.timurnabiyev.postgresql_course.models;

public class EmployeeTerritories {
    private Integer employee;
    private String territoryId;

    public EmployeeTerritories() {
    }

    public EmployeeTerritories(Integer employee, String territoryId) {
        this.employee = employee;
        this.territoryId = territoryId;
    }

    public Integer getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }

    public String getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryId) {
        this.territoryId = territoryId;
    }
}
