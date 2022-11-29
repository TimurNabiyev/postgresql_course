package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.CustomerCustomerDemo;

public interface CustomerCustomerDemoDao {
    public CustomerCustomerDemo find(Long customerCustomerDemoId);

    public CustomerCustomerDemo save(CustomerCustomerDemo customerCustomerDemo);
}
