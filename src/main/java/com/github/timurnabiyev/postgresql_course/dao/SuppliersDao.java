package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Suppliers;

public interface SuppliersDao {
    public Suppliers find(Long supplierId);

    public Suppliers save(Suppliers suppliers);
}
