package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Customers;

public interface CustomersDao {
    public Customers findCustomerByID(Long id);
    public Long insertCustomer(Customers customer);
    public int getCustomerCount();
    public void getCustomers();
    public int updateCustomer(Long id, Customers customer);
    public int deleteCustomer(String id);
}
