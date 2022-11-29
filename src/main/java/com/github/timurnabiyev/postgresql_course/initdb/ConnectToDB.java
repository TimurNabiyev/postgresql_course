package com.github.timurnabiyev.postgresql_course.initdb;

import java.sql.*;

public class ConnectToDB {
    private static String executeQuery = null;
    public static ResultSet resultSet = null;
    private static InitToDB connect = new InitToDB();
    private static Connection connection = null;
    private static Statement statement = null;

    public static void connectToDB(String executeQuery) {
        try {
           connection = DriverManager.getConnection(connect.getUrl(), connect.getName(), connect.getPassword());
           connection.setAutoCommit(false);
            System.out.println("Database opened successfully");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(executeQuery);

            //resultSet.close();
            //statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setExecuteQuery(String executeQuery) {
        ConnectToDB.executeQuery = executeQuery;
    }
}
