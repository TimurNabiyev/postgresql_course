package com.github.timurnabiyev.postgresql_course.dao.impl;

import com.github.timurnabiyev.postgresql_course.dao.SuppliersDao;
import com.github.timurnabiyev.postgresql_course.initdb.InitToDB;
import com.github.timurnabiyev.postgresql_course.models.Suppliers;

import java.sql.*;

public class SuppliersDaoImpl implements SuppliersDao {

    @Override
    public Suppliers findSupplierByID(int supplierId) {
        String SQL = "SELECT * FROM timur.suppliers"
                + "WHERE supplier_id = ?";

        Suppliers supplier = new Suppliers();

        try (Connection connection = InitToDB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setInt(1, supplierId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                supplier.setSupplierId(resultSet.getInt("supplier_id"));
                supplier.setCompanyName(resultSet.getString("company_name"));
                supplier.setContactName(resultSet.getString("contact_name"));
                supplier.setAddress(resultSet.getString("address"));
                supplier.setCity(resultSet.getString("city"));
                supplier.setRegion(resultSet.getString("region"));
                supplier.setPostalCode(resultSet.getString("postal_code"));
                supplier.setCountry(resultSet.getString("country"));
                supplier.setPhone(resultSet.getString("phone"));
                supplier.setFax(resultSet.getString("fax"));
                supplier.setHomePage(resultSet.getURL("homepage"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return supplier;
    }

    @Override
    public long insertSupplier(Suppliers suppliers) {
        String SQL = "INSERT INTO timur.suppliers(supplier_id, company_name, contact_name, address, city, "
                    + "region, postal_code, country, phone, fax, homepage "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        long id = 0;

        try (Connection connection = InitToDB.connect();
                PreparedStatement pstmt = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, suppliers.getSupplierId());
            pstmt.setString(2, suppliers.getCompanyName());
            pstmt.setString(3, suppliers.getContactName());
            pstmt.setString(4, suppliers.getAddress());
            pstmt.setString(5, suppliers.getCity());
            pstmt.setString(6, suppliers.getRegion());
            pstmt.setString(7, suppliers.getPostalCode());
            pstmt.setString(8, suppliers.getCountry());
            pstmt.setString(9, suppliers.getPhone());
            pstmt.setString(10, suppliers.getFax());
            pstmt.setURL(11, suppliers.getHomePage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
}
