package com.github.timurnabiyev.postgresql_course;


import com.github.timurnabiyev.postgresql_course.dao.impl.CategoriesDaoImpl;
import com.github.timurnabiyev.postgresql_course.initdb.ConnectToDB;
import com.github.timurnabiyev.postgresql_course.models.*;

import java.sql.*;

public class ApplicationMain {
    public static void main(String[] args) throws SQLException {

        CategoriesDaoImpl categoriesDao = new CategoriesDaoImpl();
        Categories categories = categoriesDao.find(2);
        Products product = new Products();
        Products product2 = new Products();


            ConnectToDB.connectToDB("SELECT * FROM timur.products;");
            while (ConnectToDB.resultSet.next()) {
                product.setProductId(ConnectToDB.resultSet.getInt("product_id"));
                product.setProductName(ConnectToDB.resultSet.getString("product_name"));
                product.setSupplierId(ConnectToDB.resultSet.getInt("supplier_Id"));
                product.setCategoryId(ConnectToDB.resultSet.getInt("category_id"));
                product.setQuantityPerUnit(ConnectToDB.resultSet.getString("quantity_per_unit"));
                product.setUnitPrice(ConnectToDB.resultSet.getBigDecimal("unit_price"));
                product.setUnitsInStock(ConnectToDB.resultSet.getInt("units_in_stock"));
                product.setUnitsOnOrder(ConnectToDB.resultSet.getInt("units_on_order"));
                product.setReorderLevel(ConnectToDB.resultSet.getInt("reorder_level"));
                product.setDiscontinued(ConnectToDB.resultSet.getInt("discontinued"));

                if (ConnectToDB.resultSet.getInt("product_id") == 1) {
                    product2.setProductId(ConnectToDB.resultSet.getInt("product_id"));
                    product2.setProductName(ConnectToDB.resultSet.getString("product_name"));
                    product2.setSupplierId(ConnectToDB.resultSet.getInt("supplier_Id"));
                    product2.setCategoryId(ConnectToDB.resultSet.getInt("category_id"));
                    product2.setQuantityPerUnit(ConnectToDB.resultSet.getString("quantity_per_unit"));
                    product2.setUnitPrice(ConnectToDB.resultSet.getBigDecimal("unit_price"));
                    product2.setUnitsInStock(ConnectToDB.resultSet.getInt("units_in_stock"));
                    product2.setUnitsOnOrder(ConnectToDB.resultSet.getInt("units_on_order"));
                    product2.setReorderLevel(ConnectToDB.resultSet.getInt("reorder_level"));
                    product2.setDiscontinued(ConnectToDB.resultSet.getInt("discontinued"));
                }
            }

        System.out.println(product);
        System.out.println(product2);
        System.out.println(categories);
    }


}
