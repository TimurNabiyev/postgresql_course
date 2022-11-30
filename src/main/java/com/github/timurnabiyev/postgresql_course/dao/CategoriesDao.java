package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Categories;

import java.sql.SQLException;

public interface CategoriesDao {
   public Categories findCategoryByID(int categoryId) throws SQLException;

   public long insertCategory(Categories categories);

}
