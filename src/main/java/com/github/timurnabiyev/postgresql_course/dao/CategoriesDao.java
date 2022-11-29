package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Categories;

import java.sql.SQLException;

public interface CategoriesDao {
   public Categories find(Integer categoryId) throws SQLException;

   public Categories save(Categories categories);

}
