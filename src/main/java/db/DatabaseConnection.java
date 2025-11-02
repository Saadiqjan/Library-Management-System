package db;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DatabaseConnection 
{
    private static final String CONFIG_FILE = "/config/db.properties";

    public static Connection getConnection() 
    {
        Properties props = new Properties();

        // Use getResourceAsStream to read from classpath
        try (InputStream input = DatabaseConnection.class.getResourceAsStream(CONFIG_FILE)) 
        {
            if (input == null) {
                System.out.println("Config file not found on classpath: " + CONFIG_FILE);
                return null;
            }

            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            return DriverManager.getConnection(url, user, password);

        } 
        catch (SQLException e) 
        {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        } 
        catch (Exception e) 
        {
            System.out.println("Failed to load config file: " + CONFIG_FILE);
            e.printStackTrace();
        }

        return null;
    }
}