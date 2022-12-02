package com.github.timurnabiyev.postgresql_course.dao.impl.query;

public final class CustomersQuery {

    private CustomersQuery() {}

    public static final String FIND_CUSTOMER_BY_ID = "" +
            "SELECT * FROM timur.customers " +
            "WHERE customer_id = ?";

    public static final String INSERT_CUSTOMER = "" +
            "INSERT INTO timur.customers(" +
            "customer_id, company_name, contact_name, contact_title, address, " +
            "city, region, postal_code, country, phone, fax) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    public static final String GET_CUSTOMERS_COUNT = "" +
            "SELECT count(*) FROM timur.customers";

    public static final String GET_CUSTOMERS = "" +
            "SELECT * FROM timur.customers";

    public static final String UPDATE_CUSTOMER_BY_ID = "" +
            "UPDATE timur.customers SET company_name, contact_name, contact_title, address, " +
            "city, region, postal_code, country, phone, fax" +
            "WHERE customer_id = ?";

    public static final String DELETE_CUSTOMER_BY_ID = "" +
            "DELETE FROM timur.customers WHERE customer_id = ?";
}
