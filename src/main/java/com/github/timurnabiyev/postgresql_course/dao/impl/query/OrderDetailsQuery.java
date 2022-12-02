package com.github.timurnabiyev.postgresql_course.dao.impl.query;

public final class OrderDetailsQuery {

    private OrderDetailsQuery() {
    }

    public static final String FIND_ORDER_DETAIL_BY_ID = "" +
            "SELECT * FROM timur.order_details " +
            "WHERE order_id = ?";

    public static final String INSERT_ORDER_DETAIL = "" +
            "INSERT INTO timur.order_details(order_id, customer_id, employee_id, " +
            "order_date, required_date, shipped_date, ship_via, freight, ship_name, " +
            "ship_address, ship_city, ship_region, ship_postal_code, ship_country) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String GET_ORDER_DETAILS_COUNT = "" +
            "SELECT count(*) FROM timur.order_details";

    public static final String GET_ORDER_DETAILS = "" +
            "SELECT * FROM timur.order_details";

    public static final String UPDATE_ORDER_DETAIL_BY_ID = "" +
            "UPDATE timur.order_details SET customer_id, employee_id, order_date, required_date, shipped_date, " +
            "ship_via, freight, ship_name, ship_address, ship_city, ship_region, ship_postal_code, ship_country) " +
            "WHERE order_id = ?";

    public static final String DELETE_ORDER_DETAILS_BY_ID = "" +
            "DELETE FROM timur.order_details WHERE order_id = ?";

}
