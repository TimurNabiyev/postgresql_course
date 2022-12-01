package com.github.timurnabiyev.postgresql_course.dao.impl;

import com.github.timurnabiyev.postgresql_course.dao.CustomerCustomerDemoDao;
import com.github.timurnabiyev.postgresql_course.dao.impl.query.CustomerCustomerDemoQuery;
import com.github.timurnabiyev.postgresql_course.initdb.InitToDB;
import com.github.timurnabiyev.postgresql_course.models.CustomerCustomerDemo;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        return 0;
    }

    @Override
    public int getCustomerCustomerDemoCount() {
        return 0;
    }

    @Override
    public void getCustomerCustomerDemo() {

    }

    @Override
    public int updateCustomerCustomerDemo(Long id, CustomerCustomerDemo customerCustomerDemo) {
        return 0;
    }

    @Override
    public int deleteCustomerCustomerDemo(Long id) {
        return 0;
    }
}
