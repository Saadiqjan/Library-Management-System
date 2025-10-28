package db;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DatabaseConnection 
{
    private static final String CONFIG_FILE = "config/db.properties";

    public static Connection getConnection() 
    {
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) 
        {
            props.load(fis);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            return DriverManager.getConnection(url, user, password);
        } 
        catch (IOException e) 
        {
            System.out.println("Failed to load config file: " + CONFIG_FILE);
            e.printStackTrace();
        } 
        catch (SQLException e) 
        {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }

        return null;
    }
}