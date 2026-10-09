package dao;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import database.DatabaseConnection;
import java.sql.PreparedStatement;
import model.Car;

public class CarDAO {
  
     public void createCarTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS cars (" +
                     "id INT PRIMARY KEY," +
                     "brand VARCHAR(50) NOT NULL," +
                     "model VARCHAR(50) NOT NULL," +
                     "rent_per_day DOUBLE NOT NULL," +
                     "is_available BOOLEAN DEFAULT TRUE" +
                     ")";
        try(Connection con=DatabaseConnection.getConnection()) {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Car table created successfully!");
        }
    }


    public void insertCar(Car car) throws SQLException{
        String sql = "INSERT INTO cars (id, brand, model, rent_per_day, is_available) VALUES (?, ?, ?, ?, ?)";
        try(Connection con=DatabaseConnection.getConnection()) {
                
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, car.getCarId());
            pstmt.setString(2, car.getBrand());
            pstmt.setString(3, car.getModel());
            pstmt.setDouble(4, car.getRentPerDay());
            pstmt.setBoolean(5, car.isAvailable());

            pstmt.executeUpdate();

            System.out.println("Car inserted successfully!");
        }
    }



    public static void main(String args[]) throws Exception{
         CarDAO  carDAO=new CarDAO();
         carDAO.createCarTable(DatabaseConnection.getConnection());
           Car car = new Car(1, "Toyota", "Camry", 1500.0);
           Car car2 = new Car(2, "mahindra", "punch", 2000.0);
          carDAO.insertCar(car);
          carDAO.insertCar(car2);
    }
}
