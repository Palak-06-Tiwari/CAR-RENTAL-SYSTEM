import model.Car;
import service.RentalService;

public class RentalSystem {

    public static void main(String[] args) {

        RentalService rentalService = new RentalService();

        Car car1 = new Car("c001", "Toyota", "Camry", 60.0);
        Car car2 = new Car("c002", "Honda", "Shine", 50.0);
        Car car3 = new Car("c003", "Mahindra", "Thar", 150.0);
        rentalService.addCar(car1);
        rentalService.addCar(car2);
        rentalService.addCar(car3);

        System.out.println("Car Rental System Started");
        System.out.println(
            "Available Cars: "
            + rentalService.getCars().size()
        );
    }
}