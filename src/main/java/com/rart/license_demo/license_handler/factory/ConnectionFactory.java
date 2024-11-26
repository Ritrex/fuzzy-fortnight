package com.rart.license_demo.license_handler.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection(){
        try(
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/",
                "root",
                "admin");
        ){
            return conn;
        }
        catch (SQLException sqle){
            System.out.println("No connection available");
            throw new RuntimeException(sqle);

        }
    }

}
