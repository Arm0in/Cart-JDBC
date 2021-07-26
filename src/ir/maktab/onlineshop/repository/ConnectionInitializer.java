package ir.maktab.onlineshop.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionInitializer {
    private static final String DB_NAME = "hw8db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "@A135246789a";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + DB_NAME,
                    DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            System.out.println("Error In DataBase Connection : " + throwables);
            return null;
        }
    }
}
