package com.github.timurnabiyev.postgresql_course;



import com.github.timurnabiyev.postgresql_course.dao.CategoriesDao;
import com.github.timurnabiyev.postgresql_course.dao.SuppliersDao;
import com.github.timurnabiyev.postgresql_course.dao.impl.CategoriesDaoImpl;
import com.github.timurnabiyev.postgresql_course.dao.impl.SuppliersDaoImpl;

import java.sql.*;

public class ApplicationMain {
    public static void main(String[] args) throws SQLException {
        SuppliersDao suppliersDao = new SuppliersDaoImpl();
        suppliersDao.getSuppliers();

    }

}
