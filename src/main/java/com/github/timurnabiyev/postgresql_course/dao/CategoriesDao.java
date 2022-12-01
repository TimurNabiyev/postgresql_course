package com.github.timurnabiyev.postgresql_course.dao;

import com.github.timurnabiyev.postgresql_course.models.Categories;

import java.sql.SQLException;

public interface CategoriesDao {
   public Categories findCategoryByID(Long categoryId);

   public long insertCategory(Categories categories);

   public int getCategoriesCount();
   public void getCategories();
   public int updateUsState(Long id, Categories category);
   public int deleteCategory(Long id);


}
