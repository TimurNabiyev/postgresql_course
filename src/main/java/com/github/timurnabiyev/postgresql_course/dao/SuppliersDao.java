package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Suppliers;

public interface SuppliersDao {
    public Suppliers findSupplierByID(Long id);
    public long insertSupplier(Suppliers supplier);
    public int getSuppliersCount();
    public void getSuppliers();
    public int updateSupplier(Long id, Suppliers supplier);
    public int deleteCategory(Long id);

}
