package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Customers;

public interface CustomersDao {
    public Customers find(Long customerId);
    public Customers save(Customers customers);
}
