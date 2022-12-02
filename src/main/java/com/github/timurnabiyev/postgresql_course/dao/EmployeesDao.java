package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Employees;

public interface EmployeesDao {
    public Employees findEmployeeById(Long Id);
    public long insertEmployee(Employees employee);
    public int getEmployeeCount();
    public void getEmployees();
    public int updateEmployee(Long id, Employees employee);
    public int deleteEmployee(Long id);
}
