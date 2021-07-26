package ir.maktab.onlineshop.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionInitializer {
    private Connection connection;
    private String dbName;
    private String user;
    private String password;

    public ConnectionInitializer(String dbName, String user, String password) {
        this.dbName = dbName;
        this.user = user;
        this.password = password;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbName,
                    user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
