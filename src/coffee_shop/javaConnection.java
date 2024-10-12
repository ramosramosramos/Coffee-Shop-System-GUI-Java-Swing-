
package coffee_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class javaConnection {
    public static Connection database(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
         
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");

            setupDatabase(conn);
            return conn;
        } catch (Exception e) {
            System.out.println("Not connected to database");
            System.err.println(e);
        }
        return null;
    }
    
    
    
    public static void setupDatabase(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS CoffeeDatabase");
            stmt.executeUpdate("USE CoffeeDatabase");

            try (PreparedStatement pstPreviousTable = conn.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS PreviousCoffeeTable ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "item_name VARCHAR(100) NOT NULL, "
                    + "item_quantity VARCHAR(100) NOT NULL, "
                    + "item_amount VARCHAR(100) NOT NULL, "
                    + "order_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP)")) {
                pstPreviousTable.executeUpdate();
  
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
