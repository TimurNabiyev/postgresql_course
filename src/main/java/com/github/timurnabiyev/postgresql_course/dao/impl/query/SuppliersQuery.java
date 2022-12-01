package com.github.timurnabiyev.postgresql_course.dao.impl.query;

import com.github.timurnabiyev.postgresql_course.models.Suppliers;

public final class SuppliersQuery {
    private SuppliersQuery() {
    }

    public static final String FIND_SUPPLIER_BY_ID = "" +
            "SELECT * FROM timur.suppliers " +
            "WHERE supplier_id = ?";

    public static final String INSERT_SUPPLIER = "" +
            "INSERT INTO timur.suppliers(supplier_id, company_name, contact_name, contact_title, " +
            "address, city, region, postal_code, country, phone, fax, homepage) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    public static final String GET_SUPPLIERS_COUNT = "" +
            "SELECT count(*) FROM timur.suppliers";

    public static final String GET_SUPPLIERS = "" +
            "SELECT * FROM timur.suppliers";

    public static final String UPDATE_SUPPLIER_BY_ID = "" +
            "UPDATE timur.suppliers SET company_name, contact_name, address, " +
            "city, region, postal_code, country, phone, fax, homepage " +
            "WHERE supplier_id = ?";

    public static final String DELETE_SUPPLIER_BAY_ID = "" +
            "DELETE FROM timur.suppliers WHERE supplier_id = ?";
}
