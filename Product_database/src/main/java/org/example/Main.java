package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[]args)throws SQLException {
        //Load & Register Driver
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        //Create Connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cap_player",
                "root",
                "sunil@361327"
        );
        System.out.println("Connected to database successfully");
        Product_Services product_service = new Product_Services();
        boolean require=true;
        while(require==true) {
            System.out.println("JDBC CRUD Operations");
            System.out.println("1: Add Product");
            System.out.println("2: View All Products");

            System.out.println("3: Delete Product");
            System.out.println("4: Exit");

            System.out.println("ENTER YOUR CHOICE");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 1) {
                product_service.addProduct(connection);
            } else if (choice == 2) {
                product_service.viewAllProducts(connection);
            } else if (choice == 3) {
                product_service.deleteProduct(connection);
            } else if (choice == 4) {
                require=false;
                connection.close();
                System.out.println("Goodbye!");
            }
        }
    }
}
