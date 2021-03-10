package com.company.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//we followed Single responsibility principle in this class
public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException { //method to get connection with database
        String connectionUrl = "jdbc:postgresql://localhost:5432/endterm";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "097865");

            return con;//returns way to database (connection)
        } catch (Exception e) {
            System.out.println(e);
            return null;//if there is error(exception), then returns null
        }
    }
}
