package com.rart.license_demo.license_handler.factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    @Value("${spring.datasource.url}")
    private static String url;
    @Value("${spring.datasource.username}")
    private static String usr;
    @Value("${spring.datasource.password}")
    private static String pass;


    public static Connection getConnection(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/licenses?useSSL=false&serverTimezone=UTC",
                    "root",
                    "admin");
            return conn;

        }
        catch (SQLException sqle){
            System.out.println("No connection available:"+url);

            throw new RuntimeException(sqle);

        }
    }

}
