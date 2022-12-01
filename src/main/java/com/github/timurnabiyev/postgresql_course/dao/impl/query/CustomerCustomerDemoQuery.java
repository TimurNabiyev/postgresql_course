package com.github.timurnabiyev.postgresql_course.dao.impl.query;

import com.github.timurnabiyev.postgresql_course.models.CustomerCustomerDemo;

public final class CustomerCustomerDemoQuery {
   private CustomerCustomerDemoQuery() {}

   public static final String FIND_CUSTOMER_CUSTOMER_DEMO_BY_ID = "" +
           "SELECT * FROM timur.customer_customer_demo" +
           "WHERE customer_id = ?";

   public static final String INSERT_CUSTOMER_CUSTOMER_DEMO = "" +
           "INSERT INTO timur.customer_customer_demo(customer_id, customer_type_id) " +
           "VALUES(?,?)";

   public static final String GET_CUSTOMER_CUSTOMER_DEMO_COUNT = "" +
           "SELECT count(*) FROM timur.customer_customer_demo";

   public static final String GET_CUSTOMER_CUSTOMER_DEMO = "" +
           "SELECT * FROM timur.categories";

   public static final String UPDATE_CUSTOMER_CUSTOMER_DEMO_BY_ID = "" +
           "UPDATE timur.customer_customer_demo SET customer_id, customer_type_id " +
           "WHERE customer_id = ?";

   public static final String DELETE_CUSTOMER_CUSTOMER_DEMO_BY_ID = "" +
           "DELETE FROM timur.customer_customer_demo WHERE customer_id = ?";

}
