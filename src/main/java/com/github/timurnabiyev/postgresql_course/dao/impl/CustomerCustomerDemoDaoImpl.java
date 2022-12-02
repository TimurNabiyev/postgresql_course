package com.github.timurnabiyev.postgresql_course.dao.impl;

import com.github.timurnabiyev.postgresql_course.dao.CustomerCustomerDemoDao;
import com.github.timurnabiyev.postgresql_course.dao.impl.query.CustomerCustomerDemoQuery;
import com.github.timurnabiyev.postgresql_course.initdb.InitToDB;
import com.github.timurnabiyev.postgresql_course.models.CustomerCustomerDemo;
import lombok.NoArgsConstructor;

import java.sql.*;

@NoArgsConstructor
public class CustomerCustomerDemoDaoImpl implements CustomerCustomerDemoDao {

    @Override
    public CustomerCustomerDemo findCustomerCustomerDemoByID(Long categoryId) {
        CustomerCustomerDemo cd = null;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(CustomerCustomerDemoQuery.FIND_CUSTOMER_CUSTOMER_DEMO_BY_ID)) {

            pstmt.setLong(1, categoryId);
            ResultSet rs = pstmt.executeQuery();
            cd = new CustomerCustomerDemo();
            while (rs.next()) {
                cd.setCustomerId(rs.getLong("customer_id"));
                cd.setCustomerTypeId(rs.getLong("customer_type_id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cd;
    }

    @Override
    public long insertCustomerCustomerDemo(CustomerCustomerDemo customerCustomerDemo) {
        long id = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(CustomerCustomerDemoQuery.INSERT_CUSTOMER_CUSTOMER_DEMO)) {

            pstmt.setLong(1, customerCustomerDemo.getCustomerId());
            pstmt.setLong(2, customerCustomerDemo.getCustomerTypeId());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 20;
    }

    @Override
    public int getCustomerCustomerDemoCount() {
        int count = 0;
        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(CustomerCustomerDemoQuery.GET_CUSTOMER_CUSTOMER_DEMO_COUNT)) {

            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public void getCustomerCustomerDemo() {
        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(CustomerCustomerDemoQuery.GET_CUSTOMER_CUSTOMER_DEMO)) {
            displayCustomerCustomerDemo(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int updateCustomerCustomerDemo(Long id, CustomerCustomerDemo customerCustomerDemo) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(CustomerCustomerDemoQuery.UPDATE_CUSTOMER_CUSTOMER_DEMO_BY_ID)) {

            pstmt.setLong(1, customerCustomerDemo.getCustomerId());
            pstmt.setLong(2, customerCustomerDemo.getCustomerTypeId());
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    @Override
    public int deleteCustomerCustomerDemo(Long id) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(CustomerCustomerDemoQuery.DELETE_CUSTOMER_CUSTOMER_DEMO_BY_ID)) {

            pstmt.setLong(1, id);
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    private void displayCustomerCustomerDemo(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.printf("%-5s%-5s%n", rs.getLong("customer_id"), rs.getLong("customer_type_id"));
        }
    }
}
