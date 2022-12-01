package com.github.timurnabiyev.postgresql_course.dao.impl;

import com.github.timurnabiyev.postgresql_course.dao.SuppliersDao;
import com.github.timurnabiyev.postgresql_course.dao.impl.query.SuppliersQuery;
import com.github.timurnabiyev.postgresql_course.initdb.InitToDB;
import com.github.timurnabiyev.postgresql_course.models.Suppliers;

import java.sql.*;

public class SuppliersDaoImpl implements SuppliersDao {

    @Override
    public Suppliers findSupplierByID(Long id) {

        Suppliers supplier = null;

        try (Connection connection = InitToDB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SuppliersQuery.FIND_SUPPLIER_BY_ID)) {

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            supplier = new Suppliers();

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
        long id = 0;

        try (Connection connection = InitToDB.connect();
             PreparedStatement pstmt = connection.prepareStatement(SuppliersQuery.INSERT_SUPPLIER,
                     Statement.RETURN_GENERATED_KEYS)) {

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


    @Override
    public int getSuppliersCount() {
        int count = 0;

        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SuppliersQuery.GET_SUPPLIERS_COUNT)) {

            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return count;
    }

    @Override
    public void getSuppliers() {
        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SuppliersQuery.GET_SUPPLIERS)) {
            displaySuppliers(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int updateSupplier(Long id, Suppliers supplier) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(SuppliersQuery.UPDATE_SUPPLIER_BY_ID)) {

            pstmt.setString(1, supplier.getCompanyName());
            pstmt.setString(2, supplier.getContactName());
            pstmt.setString(3, supplier.getContactTitle());
            pstmt.setString(4, supplier.getAddress());
            pstmt.setString(5, supplier.getCity());
            pstmt.setString(6, supplier.getRegion());
            pstmt.setString(7, supplier.getPostalCode());
            pstmt.setString(8, supplier.getCountry());
            pstmt.setString(9, supplier.getPhone());
            pstmt.setString(10, supplier.getFax());
            pstmt.setURL(11, supplier.getHomePage());
            pstmt.setLong(12, id);
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    @Override
    public int deleteCategory(Long id) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(SuppliersQuery.DELETE_SUPPLIER_BAY_ID)) {

            pstmt.setLong(1, id);
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    private void displaySuppliers(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.printf("%-3s%-40s%-28s%-29s%-47s%-15s%-10s%-9s%-13s%-16s%-16s%-92s%n",
                    rs.getString("supplier_id"), rs.getString("company_name"), rs.getString("contact_name"),
                    rs.getString("contact_title"), rs.getString("address"), rs.getString("city"),
                    rs.getString("region"), rs.getString("postal_code"), rs.getString("country"),
                    rs.getString("phone"), rs.getString("fax"), rs.getString("homepage"));
        }
        System.out.println();
    }
}
