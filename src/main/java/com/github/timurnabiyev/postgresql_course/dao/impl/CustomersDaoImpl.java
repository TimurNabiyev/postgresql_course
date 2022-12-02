package com.github.timurnabiyev.postgresql_course.dao.impl;

import com.github.timurnabiyev.postgresql_course.dao.CustomersDao;
import com.github.timurnabiyev.postgresql_course.dao.impl.query.CustomersQuery;
import com.github.timurnabiyev.postgresql_course.initdb.InitToDB;
import com.github.timurnabiyev.postgresql_course.models.Customers;
import lombok.NoArgsConstructor;

import java.sql.*;
@NoArgsConstructor
public class CustomersDaoImpl implements CustomersDao {

    @Override
    public Customers findCustomerByID(Long id) {
        Customers customer = null;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(CustomersQuery.FIND_CUSTOMER_BY_ID)) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            customer = new Customers();

            while (rs.next()) {
                customer.setCustomerId(rs.getString("customer_id"));
                customer.setCompanyName(rs.getString("customer_name"));
                customer.setContactName("contact_name");
                customer.setContactTitle("contact_title");
                customer.setAddress("address");
                customer.setCity(rs.getString("city"));
                customer.setRegion(rs.getString("region"));
                customer.setPostalCode(rs.getString("postal_code"));
                customer.setCountry(rs.getString("country"));
                customer.setPhone(rs.getString("phone"));
                customer.setFax(rs.getString("fax"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return customer;
    }

    @Override
    public Long insertCustomer(Customers customer) {
        long id = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(CustomersQuery.INSERT_CUSTOMER,
                     Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, customer.getCustomerId());
            pstmt.setString(2, customer.getCompanyName());
            pstmt.setString(3, customer.getContactName());
            pstmt.setString(4, customer.getContactTitle());
            pstmt.setString(5, customer.getAddress());
            pstmt.setString(6, customer.getCity());
            pstmt.setString(7, customer.getRegion());
            pstmt.setString(8, customer.getPostalCode());
            pstmt.setString(9, customer.getCountry());
            pstmt.setString(10, customer.getPhone());
            pstmt.setString(11, customer.getFax());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    @Override
    public int getCustomerCount() {
        int count = 0;

        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(CustomersQuery.GET_CUSTOMERS_COUNT)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    @Override
    public void getCustomers() {
        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(CustomersQuery.GET_CUSTOMERS)) {
            displayCustomers(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int updateCustomer(Long id, Customers customer) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(CustomersQuery.UPDATE_CUSTOMER_BY_ID)) {

            pstmt.setString(1, customer.getCompanyName());
            pstmt.setString(2, customer.getContactName());
            pstmt.setString(3, customer.getContactTitle());
            pstmt.setString(4, customer.getAddress());
            pstmt.setString(5, customer.getCity());
            pstmt.setString(6, customer.getRegion());
            pstmt.setString(7, customer.getPostalCode());
            pstmt.setString(8, customer.getCountry());
            pstmt.setString(9, customer.getPhone());
            pstmt.setString(10, customer.getFax());

            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    @Override
    public int deleteCustomer(String id) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(CustomersQuery.DELETE_CUSTOMER_BY_ID)) {

            pstmt.setString(1, id);
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    private void displayCustomers(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.printf("%-7s%-38s%-25s%-32s%-48s%-17s%-15s%-11s%-13s%-19s%-19s%n",
                    rs.getString("customer_id"), rs.getString("company_name"), rs.getString("contact_name"),
                    rs.getString("contact_title"), rs.getString("address"), rs.getString("city"),
                    rs.getString("region"), rs.getString("postal_code"), rs.getString("country"),
                    rs.getString("phone"), rs.getString("fax"));
        }
        System.out.println();
    }
}
