package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Orders;

public interface OrdersDao {
    public Orders find(Long orderId);
    public Orders save(Orders orders);
}
