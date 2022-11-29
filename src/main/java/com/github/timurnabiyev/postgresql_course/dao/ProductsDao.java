package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Products;

public interface ProductsDao {
    public Products find(Long productId);
    public Products save(Products products);
}
