package service;

import java.util.ArrayList;
import java.util.List;

import model.Car;
import model.Customer;
import model.Rental;

public class RentalService {

    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public RentalService() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {

        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
        } else {
            System.out.println("Car is not available for rent");
        }
    }

    public void returnCar(Car car) {

        car.returnCar();

        Rental rentalToRemove = null;

        for (Rental r : rentals) {

            if (r.getCar() == car) {
                rentalToRemove = r;
                break;
            }
        }

        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
        } else {
            System.out.println("Car was not rented");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}