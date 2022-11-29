package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Shippers;

public interface ShippersDao {
    public Shippers find(Long shipperId);
    public Shippers save(Shippers shippers);
}
