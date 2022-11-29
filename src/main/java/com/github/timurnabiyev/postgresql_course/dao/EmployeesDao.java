package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Employees;

public interface EmployeesDao {
    public Employees find(Long employeeId);
    public Employees save(Employees employees);
}
