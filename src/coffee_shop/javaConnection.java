
package coffee_shop;

import java.sql.Connection;
import java.sql.DriverManager;

public class javaConnection {
    public static Connection database(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
         
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
            System.out.println("Connected to database");
            return conn;
        } catch (Exception e) {
            System.out.println("Not connected to database");
            System.err.println(e);
        }
        return null;
    }
}
