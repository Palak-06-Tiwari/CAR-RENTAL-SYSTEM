package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) {
        try{
             String url = "jdbc:mysql://localhost:3306/car_rental";
             String username = "root";
             String password = "root123";
            Connection con = DriverManager.getConnection(url, username, password);

            if(con != null){
                System.out.println("Connected to the database!");
            }else{
                System.out.println("Failed to connect to the database.");
            }

            //  Statement stmt = con.createStatement();
            // stmt.executeUpdate(sql);

            // System.out.println("Database created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}