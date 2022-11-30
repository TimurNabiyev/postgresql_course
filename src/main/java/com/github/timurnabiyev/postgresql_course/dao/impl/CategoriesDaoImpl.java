package com.github.timurnabiyev.postgresql_course.dao.impl;

import com.github.timurnabiyev.postgresql_course.dao.CategoriesDao;
import com.github.timurnabiyev.postgresql_course.initdb.ConnectToDB;
import com.github.timurnabiyev.postgresql_course.initdb.InitToDB;
import com.github.timurnabiyev.postgresql_course.models.Categories;

import java.sql.*;

public class CategoriesDaoImpl implements CategoriesDao {

    public CategoriesDaoImpl() {

    }

    @Override
    public Categories findCategoryByID(int categoryId) {
        String SQL = "SELECT category_id, category_name, description "
                + "FROM timur.categories "
                + "WHERE category_id = ?";

        Categories categories = new Categories();

        try (Connection connection = InitToDB.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                categories.setCategoryId(resultSet.getInt("category_id"));
                categories.setCategoryName(resultSet.getString("category_name"));
                categories.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return categories;
    }

    @Override
    public long insertCategory(Categories categories) {
        String SQL = "INSERT INTO timur.categories(category_id, category_name, description) "
                + "VALUES(?,?,?)";
        long id = 0;

        try (Connection connection = InitToDB.connect();
                PreparedStatement pstmt = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, categories.getCategoryId());
            pstmt.setString(2, categories.getCategoryName());
            pstmt.setString(3, categories.getDescription());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
}
