package ui;
import java.util.Scanner;
import dao.CarDAO;
import model.Car;

public class RentalSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CarDAO carDAO = new CarDAO();

        try {
            System.out.println("===== ADD NEW CAR =====");

            System.out.print("Enter Car ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Brand: ");
            String brand = sc.nextLine();

            System.out.print("Enter Model: ");
            String model = sc.nextLine();

            System.out.print("Enter Rent Per Day: ");
            double rent = Double.parseDouble(sc.nextLine());

            Car car = new Car(id, brand, model, rent);

            // JDBC se database mein insert hoga
            carDAO.insertCar(car);

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
