package com.github.timurnabiyev.postgresql_course.initdb;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InitToDB {
    private static File pathToInitPath;
    private static File pathToInitFile;
    private static String url;
    private static String name;
    private static String password;
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
        System.out.println("Please enter the path to the folder with init_db.txt file");
        pathToInitPath = new File(scanner.nextLine());
        pathToInitFile = new File(pathToInitPath + "\\init_db.txt");

        while (!pathToInitFile.exists()) {
            System.out.println("Please enter correct path to init_db file");
            File newScanPath = new File(scanner.nextLine());
            pathToInitFile = new File(newScanPath + "\\init_db.txt");
        }
        readInitDBFile();

        System.out.println("InitDB file readied");
    }



    public InitToDB() {

    }

    private static void readInitDBFile() {
        try {
            scanner = new Scanner(pathToInitFile);
            while (scanner.hasNext()) {
                url = scanner.nextLine();
                name = scanner.nextLine();
                password = scanner.nextLine();
                System.out.println(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getUrl() {
        return url;
    }

    public static String getName() {
        return name;
    }

    public static String getPassword() {
        return password;
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, name, password);
    }
}
