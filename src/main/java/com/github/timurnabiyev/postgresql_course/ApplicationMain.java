package com.github.timurnabiyev.postgresql_course;


import com.github.timurnabiyev.postgresql_course.dao.impl.CategoriesDaoImpl;
import com.github.timurnabiyev.postgresql_course.initdb.ConnectToDB;
import com.github.timurnabiyev.postgresql_course.models.*;

import java.sql.*;

public class ApplicationMain {
    public static void main(String[] args) throws SQLException {

        CategoriesDaoImpl categoriesDao = new CategoriesDaoImpl();
        Categories category = new Categories();
        category.setCategoryId(11);
        category.setCategoryName("SomeCategory");
        category.setDescription("Some description fo test");
        long categoryId = categoriesDao.insertCategory(category);

        if (categoryId == 0) {

        } else {
            System.out.println(
                    String.format("%s, %s category has been inserted with id %d",
                    category.getCategoryName(), category.getDescription(), categoryId));
        }

        category = categoriesDao.findCategoryByID(1);
        System.out.println(category);
    }

}
