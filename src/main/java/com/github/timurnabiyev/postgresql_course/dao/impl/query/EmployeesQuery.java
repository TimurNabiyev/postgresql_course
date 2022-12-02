package com.github.timurnabiyev.postgresql_course.dao.impl.query;

import com.github.timurnabiyev.postgresql_course.dao.EmployeesDao;
import com.github.timurnabiyev.postgresql_course.models.Employees;

public final class EmployeesQuery  {
    private EmployeesQuery() {}

   public static final String FIND_EMPLOYEE_BY_ID = "" +
           "SELECT * FROM timur.employees " +
           "WHERE timur.employee_id = ?";

    public static final String INSERT_EMPLOYEE = "" +
            "INSERT INTO timur.employees(employee_id, last_name, first_name, title, " +
            "title_of_courtesy, birth_date, hire_date, address, city, region, postal_code, " +
            "country, home_phone, extension, photo, notes, reports_to, photo_path) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String GET_EMPLOYEES_COUNT = "" +
            "SELECT count(*) FROM timur.employees";

    public static final String GET_EMPLOYEES = "" +
            "SELECT * FROM timur.employees";

    public static final String UPDATE_EMPLOYEE_BY_ID = "" +
            "UPDATE timur.employees SET last_name, first_name, title, title_of_courtesy, " +
            "birth_date, hire_date, address, city, region, postal_code, country, home_phone, " +
            "extension, photo, notes, reports_to, photo_path " +
            "WHERE employee_id = ?";

    public static final String DELETE_EMPLOYEE_BY_ID = "" +
            "DELETE FROM timur.employees WHERE employee_id = ?";
}
