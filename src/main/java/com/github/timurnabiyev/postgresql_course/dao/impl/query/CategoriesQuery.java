package com.github.timurnabiyev.postgresql_course.dao.impl.query;

public final class CategoriesQuery {

    private CategoriesQuery() {}

    public static final String FIND_CATEGORY_BY_ID = "" +
            "SELECT * FROM timur.categories " +
            "WHERE category_id = ?";

    public static final String INSERT_CATEGORY = "" +
            "INSERT INTO timur.categories(category_id, category_name, description, picture) " +
            "VALUES(?,?,?,?)";

    public static final String GET_CATEGORIES_COUNT = "" +
            "SELECT count(*) FROM timur.categories";

    public static final String GET_CATEGORIES = "" +
            "SELECT category_id, category_name, description FROM timur.categories";

    public static final String UPDATE_CATEGORY_BY_ID = "" +
            "UPDATE timur.categories SET category_name, description, picture" +
            "WHERE category_id = ?";

    public static final String DELETE_CATEGORY_BY_ID = "" +
            "DELETE FROM timur.categories WHERE category_id = ?";
}
