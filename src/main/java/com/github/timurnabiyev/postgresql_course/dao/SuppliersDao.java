package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Suppliers;

public interface SuppliersDao {
    public Suppliers findSupplierByID(int supplierId);

    public long insertSupplier(Suppliers suppliers);
}
