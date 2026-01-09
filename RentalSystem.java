import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Car{
    private String carId;

    private String brand;
 
    private String model;

    private double rentPerDay;

    private boolean isAvailable;

    public Car(String carId,String brand,String model,double rentPerDay){
     this.carId=carId;
     this.brand=brand;
     this.model=model;
     this.rentPerDay=rentPerDay; 
     this.isAvailable=true; 
    }

    public String getcarId(){
        return carId;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }
    
    public double calculatePrice(int rentalDays){
        return rentPerDay * rentalDays;
    }
    
    public boolean isAvailable(){
        return isAvailable;
    }

    public void rent(){
        isAvailable=false;
    }

    public void returnCar(){
        isAvailable=true;
    }
    
}

class Customer {
private String customerId;

private String name;

public Customer(String customerId,String name){
    this.customerId=customerId;
    this.name=name;
}

public String getCustomerId(){
    return name;
}

public String getName(){
    return name;
}
    
}



class Rental{
 private Car car; // car->reference to Car class object

 private Customer customer; //cutomer ->refernce to Customer class object

 private int days;

// “The Rental class uses composition by holding references
//  to Car and Customer objects, which are initialized
//   using a constructor during object creation.”

public Rental(Car car,Customer customer,int days){

    this.car=car;
    this.customer=customer;
    this.days=days;
}

public Car getCar(){
    return car;
}

public Customer getCustomer(){
  return customer;
}

public int getDay(){
    return days;
}

}


class carRentalSystem{

private List<Car> cars;

private List<Customer>customers;

private List<Rental>rentals;



public carRentalSystem(){
    cars=new ArrayList<>();
    customers=new ArrayList<>();
    rentals=new ArrayList<>();
}

public void addCar(Car car){
    cars.add(car);
}


public void addCustomer(Customer customer){
    customers.add(customer);
}


public void rentCar(Car car,Customer customer,int days){
    if(car.isAvailable()){
        car.rent();
        rentals.add(new Rental(car, customer, days));
    }
    else{
     System.out.println("car is not available for rent");   
    }
}


public void returnCar(Car car){
    car.returnCar();
    Rental rentaltoremove=null;
    for(Rental r:rentals){
       if(r.getCar()==car){
        rentaltoremove=r;
        break;
       } 
    }

    if(rentaltoremove!=null){
        rentals.remove(rentaltoremove);
        System.out.println("car returned successfully");
    }
    else{
        System.out.println("car was not rented");
    }
}

}



    public class RentalSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Car Rental System!!");
    }
}