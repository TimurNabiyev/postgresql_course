package com.github.timurnabiyev.postgresql_course.dao.impl;

import com.github.timurnabiyev.postgresql_course.dao.CategoriesDao;
import com.github.timurnabiyev.postgresql_course.initdb.ConnectToDB;
import com.github.timurnabiyev.postgresql_course.models.Categories;

import java.sql.SQLException;

public class CategoriesDaoImpl implements CategoriesDao {

    public CategoriesDaoImpl() {

    }

    public Categories find(Integer categoryId) throws SQLException {
        Categories categories = new Categories();
        ConnectToDB.connectToDB("SELECT * FROM timur.categories WHERE category_id = " + categoryId + ";");
        System.out.println("Select command was ended");
        while (ConnectToDB.resultSet.next()) {
            categories.setCategoryId(ConnectToDB.resultSet.getInt("category_id"));
            categories.setCategoryName(ConnectToDB.resultSet.getString("category_name"));
            categories.setDescription(ConnectToDB.resultSet.getString("description"));
        }
        return categories;
    }

    public Categories save(Categories categories) {
        return null;
    }
}
