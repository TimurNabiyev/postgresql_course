package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Categories;
import com.github.timurnabiyev.postgresql_course.models.CustomerCustomerDemo;

public interface CustomerCustomerDemoDao {
    public CustomerCustomerDemo findCustomerCustomerDemoByID(Long categoryId);
    public long insertCustomerCustomerDemo(CustomerCustomerDemo customerCustomerDemo);
    public int getCustomerCustomerDemoCount();
    public void getCustomerCustomerDemo();
    public int updateCustomerCustomerDemo(Long id, CustomerCustomerDemo customerCustomerDemo);
    public int deleteCustomerCustomerDemo(Long id);

}
