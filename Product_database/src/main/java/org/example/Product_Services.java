package org.example;

import java.util.Scanner;
import java.sql.*;


public class Product_Services  {


        public static void addProduct(Connection connection) throws SQLException{

            Scanner sc = new Scanner(System.in);

                // 🔹 Take Input
                System.out.print("Enter Product ID: ");
                int productId = sc.nextInt();
                sc.nextLine(); // consume leftover newline

                System.out.print("Enter Product Name: ");
                String productName = sc.nextLine();

                System.out.print("Enter Category: ");
                String category = sc.nextLine();

                System.out.print("Enter Price: ");
                double price = sc.nextDouble();

                System.out.print("Enter Quantity: ");
                int quantity = sc.nextInt();

                System.out.print("Enter Rating (1-5): ");
                double rating = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter manufacturer: ");
                String manufacturer = sc.nextLine();

                // 🔹 Validations

                // Check price
                if (price <= 0) {
                    System.out.println(" Price must be greater than 0.");
                    return;
                }

                // Check quantity
                if (quantity < 0) {
                    System.out.println("Quantity cannot be negative.");
                    return;
                }

                // Check rating
                if (rating < 1 || rating > 5) {
                    System.out.println(" Rating must be between 1 and 5.");
                    return;
                }

                // 🔹 Check if Product ID already exists
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(
                        "SELECT product_id FROM products WHERE product_id = " + productId);

                if (rs.next()) {
                    System.out.println(" Product ID already exists!");
                    return;
                }

                // 🔹 Insert Query
                String insertQuery = "INSERT INTO products " +
                        "(product_id, product_name, category, price, quantity, rating, manufacturer) VALUES (" +
                        productId + ", '" +
                        productName + "', '" +
                        category + "', " +
                        price + ", " +
                        quantity + ", " +
                        rating + ", '" +
                        manufacturer + "')";

                int rows = statement.executeUpdate(insertQuery);

                if (rows > 0) {
                    System.out.println(" Product added successfully!");
                } else {
                    System.out.println("Failed to add product.");
                }


            }
    public static void viewAllProducts(Connection connection)throws SQLException {

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM products";

            ResultSet rs = statement.executeQuery(query);

            boolean isEmpty = true;

            System.out.println("\n========= PRODUCT LIST =========");

            while (rs.next()) {
                isEmpty = false;

                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                String category = rs.getString("category");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                double rating = rs.getDouble("rating");
                String manufacturer = rs.getString("manufacturer");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.println("---------------------------------");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Category: " + category);
                System.out.println("Price: ₹" + price);
                System.out.println("Quantity: " + quantity);
                System.out.println("Rating: " + rating);
                System.out.println("Manufacturer: " + manufacturer);
                System.out.println("Created At: " + createdAt);
            }

            if (isEmpty) {
                System.out.println("No products found.");
            }

            System.out.println("=================================\n");

        }
    public static void deleteProduct(Connection connection) throws SQLException{

        Scanner sc = new Scanner(System.in);

            System.out.print("Enter Product ID to delete: ");
            int productId = sc.nextInt();
            sc.nextLine();  // consume newline

            Statement statement = connection.createStatement();

            // 🔹 Check if product exists
            String checkQuery = "SELECT product_id FROM products WHERE product_id = " + productId;
            ResultSet rs = statement.executeQuery(checkQuery);

            if (!rs.next()) {
                System.out.println(" Product ID not found.");
                return;
            }

            // 🔹 Confirm deletion
            System.out.print("Are you sure you want to delete this product? (Y/N): ");
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("Y")) {

                String deleteQuery = "DELETE FROM products WHERE product_id = " + productId;

                int rows = statement.executeUpdate(deleteQuery);

                System.out.println(" Product deleted successfully.");
                System.out.println("Rows affected: " + rows);

            } else {
                System.out.println("Deletion cancelled.");
            }

        }
    }



