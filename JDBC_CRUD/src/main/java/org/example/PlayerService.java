package org.example;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
public class PlayerService {
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
        System.out.println("Connected Successfully!");
        //create statement
        Statement statement = connection.createStatement();

        //--------------------Insert--------------------//

//        String query = "INSERT INTO player VALUES (5, 'Rakesh', 'India')";
//        int rows = statement.executeUpdate(query);
//        System.out.println(rows + " row inserted successfully!");

        //---------------------Read---------------------//
        ResultSet rs = statement.executeQuery("select* from player");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String country = rs.getString("country");
            System.out.println(id + "|" + name + "|" + country);
        }
        //---------------------Update---------------------//
        int rowupdated = statement.executeUpdate("update player set country='England' where id=5");
        if (rowupdated > 0) {
            System.out.println(rowupdated + "row updated");
        } else {
            System.out.println("updated failed");
        }
        //---------------------Delete---------------------//
        int rowdeleted = statement.executeUpdate("delete from player where id=5");
        if (rowdeleted > 0) {
            System.out.println(rowdeleted + "row deleted");
        }
        else  {
            System.out.println("delete failed");
        }
    }
}
