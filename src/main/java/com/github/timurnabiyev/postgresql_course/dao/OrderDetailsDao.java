package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.OrderDetails;

public interface OrderDetailsDao {
    public OrderDetails find(Long orderDetailId);
    public OrderDetails save(OrderDetails orderDetails);
}
