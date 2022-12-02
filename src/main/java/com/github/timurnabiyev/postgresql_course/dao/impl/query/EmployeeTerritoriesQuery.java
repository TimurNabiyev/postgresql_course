package com.github.timurnabiyev.postgresql_course.dao.impl.query;

public final class EmployeeTerritoriesQuery {
    private EmployeeTerritoriesQuery() {}

    public static final String FIND_EMPLOYEE_TERRITORIES_BY_ID = "" +
            "SELECT * FROM timur.employee_territories " +
            "WHERE employee_id = ?";

    public static final String INSERT_EMPLOYEE_TERRITORY = "" +
            "INSERT INTO timur.employee_territories(employee_id, territory_id) " +
            "VALUES(?,?)";

    public static final String GET_EMPLOYEE_TERRITORIES_COUNT = "" +
            "SELECT count(*) FROM timur.employee_territories";

    public static final String GET_EMPLOYEE_TERRITORIES = "" +
            "SELECT * FROM timur.employee_territories";

    public static final String UPDATE_EMPLOYEE_TERRITORIES_BY_ID = "" +
            "UPDATE timur.employee_territories SET territory_id " +
            "WHERE employee_id = ?";

    public static final String DELETE_EMPLOYEE_TERRITORY_BY_ID = "" +
            "DELETE FROM timur.employee_territories WHERE employee_id = ?";

}
