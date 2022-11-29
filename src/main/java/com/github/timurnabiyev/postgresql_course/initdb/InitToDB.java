package com.github.timurnabiyev.postgresql_course.initdb;

import java.io.File;
import java.util.Scanner;

public class InitToDB {
    private File pathToInitPath;
    private File pathToInitFile;
    private String url;
    private String name;
    private String password;
    private Scanner scanner;

    public InitToDB() {
        scanner = new Scanner(System.in);
        System.out.println("Please enter the path to the folder with init_db.txt file");
        pathToInitPath = new File(scanner.nextLine());
        pathToInitFile = new File(pathToInitPath + "\\init_db.txt");

        while (!pathToInitPath.exists()) {
            System.out.println("Please enter correct path to init_db file");
            pathToInitFile = new File(scanner.nextLine());
        }
        readInitDBFile();

        System.out.println("InitDB file readied");
    }

    private void readInitDBFile() {
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

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
