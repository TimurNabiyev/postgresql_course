package com.github.timurnabiyev.postgresql_course.dao.impl;

import com.github.timurnabiyev.postgresql_course.dao.CategoriesDao;
import com.github.timurnabiyev.postgresql_course.dao.impl.query.CategoriesQuery;
import com.github.timurnabiyev.postgresql_course.initdb.InitToDB;
import com.github.timurnabiyev.postgresql_course.models.Categories;
import lombok.NoArgsConstructor;

import java.sql.*;
@NoArgsConstructor
public class CategoriesDaoImpl implements CategoriesDao {

    @Override
    public Categories findCategoryByID(Long categoryId) {

        Categories categories = null;

        try (Connection connection = InitToDB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(CategoriesQuery.FIND_CATEGORY_BY_ID)) {

            preparedStatement.setLong(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            categories = new Categories();
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
        long id = 0;

        try (Connection connection = InitToDB.connect();
             PreparedStatement pstmt = connection.prepareStatement(CategoriesQuery.INSERT_CATEGORY, Statement.RETURN_GENERATED_KEYS)) {
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

    @Override
    public int getCategoriesCount() {
        int count = 0;

        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(CategoriesQuery.GET_CATEGORIES_COUNT)) {

            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    @Override
    public void getCategories() {
        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(CategoriesQuery.GET_CATEGORIES)) {
            displayCategories(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int updateUsState(Long id, Categories category) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(CategoriesQuery.UPDATE_CATEGORY_BY_ID)) {

            pstmt.setString(1, category.getCategoryName());
            pstmt.setString(2, category.getDescription());
            pstmt.setShort(3, category.getPicture());
            pstmt.setLong(4, id);
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    @Override
    public int deleteCategory(Long id) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(CategoriesQuery.DELETE_CATEGORY_BY_ID)) {

            pstmt.setLong(1, id);
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    private void displayCategories(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.printf("%-4s%-16s%-60s%n", rs.getString("category_id"), rs.getString("category_name"),
                    rs.getString("description"));
        }
        System.out.println();
    }
}
