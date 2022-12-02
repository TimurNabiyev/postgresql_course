package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.OrderDetails;

public interface OrderDetailsDao {
    public OrderDetails findOrderDetailById(Long id);
    public Long insertOrderDetail(OrderDetails orderDetail);
    public int getOrderDetailsCount();
    public void getOrderDetails();
    public int updateOrderDetails(Long id, OrderDetails orderDetail);
}
